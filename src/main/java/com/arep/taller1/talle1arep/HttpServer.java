package com.arep.taller1.talle1arep;

import java.net.*;
import java.io.*;
import java.nio.file.*;

public class HttpServer {

    private static final String RESOURCE_PATH = "src/main/resources/public";

    public static void main(String[] args) throws IOException, URISyntaxException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35003);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35003.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 OutputStream rawOut = clientSocket.getOutputStream();
                 PrintWriter out = new PrintWriter(rawOut, true)) {

                System.out.println("Listo para recibir ...");

                String inputLine, path = null;
                boolean firstLine = true;

                while ((inputLine = in.readLine()) != null) {
                    if (firstLine) {
                        path = inputLine.split(" ")[1]; 
                        System.out.println("Path: " + path);
                        firstLine = false;
                    }
                    System.out.println("Received: " + inputLine);
                    if (!in.ready()) break;
                }

                
                String cleanPath = path;
                if (cleanPath.contains("?")) {
                    cleanPath = cleanPath.substring(0, cleanPath.indexOf("?"));
                }

                
                if (path.startsWith("/hello")) {
                    String name = path.contains("=") ? path.split("=")[1] : "John";
                    String response = "HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/plain\r\n\r\n"
                            + "Hola " + name;
                    out.println(response);

                } else if (path.startsWith("/hellopost")) {
                    String name = path.contains("=") ? path.split("=")[1] : "John";
                    String response = "HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/plain\r\n\r\n"
                            + "Hola " + name;
                    out.println(response);

                } else if (path.startsWith("/app/hello")) {
                    
                    serveJsonHello(path, out);

                } else {
                    
                    serveStaticFile(cleanPath, rawOut, out);
                }

            } catch (IOException e) {
                System.err.println("Error manejando cliente: " + e.getMessage());
            }
        }
        serverSocket.close();
    }

    
    private static void serveJsonHello(String path, PrintWriter out) {
        String name = "Desconocido";
        if (path.contains("?") && path.contains("=")) {
            name = path.split("=")[1];
        }

        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n\r\n"
                + "{ \"mensaje\": \"Hola " + name + "\" }";

        out.println(response);
    }

    
    private static void serveStaticFile(String path, OutputStream rawOut, PrintWriter out) throws IOException {
        String resourcePath = path.equals("/") ? "/index.html" : path;

        Path filePath = Paths.get(RESOURCE_PATH + resourcePath);

        if (Files.exists(filePath)) {
            String mimeType = Files.probeContentType(filePath);
            if (mimeType == null) mimeType = "application/octet-stream";

            byte[] fileData = Files.readAllBytes(filePath);

            out.print("HTTP/1.1 200 OK\r\n");
            out.print("Content-Type: " + mimeType + "\r\n");
            out.print("Content-Length: " + fileData.length + "\r\n");
            out.print("\r\n");
            out.flush();

            rawOut.write(fileData);
            rawOut.flush();

        } else {
            String response = "HTTP/1.1 404 Not Found\r\n"
                    + "Content-Type: text/html\r\n\r\n"
                    + "<h1>404 Not Found</h1>";
            out.println(response);
        }
    }
}
