# Servidor web no concurrente
Este proyecto implementa un servidor web sencillo en **Java** que permite:
- Servir archivos estáticos como HTML, CSS, JS e imágenes.  
- Manejar solicitudes HTTP con los métodos **GET** y **POST**.  
- Responder a formularios desde el navegador. 

## Para comenzar
Estas instrucciones te permitirán obtener una copia del proyecto y ejecutarlo en tu máquina local para desarrollo y pruebas.  

### Estructura del proyecto
Puedes copiar y pegar el siguiente texto en tu archivo README.md. He incluido todo el contenido que hemos trabajado, con la estructura y la representación de la carpeta que solicitaste.

Markdown

# Servidor web no concurrente

Este proyecto implementa un servidor web sencillo en **Java** que permite:

* Servir archivos estáticos como HTML, CSS, JS e imágenes.
* Manejar solicitudes HTTP con los métodos **GET** y **POST**.
* Responder a formularios desde el navegador.

---

## Para comenzar

Estas instrucciones te permitirán obtener una copia del proyecto y ejecutarlo en tu máquina local para desarrollo y pruebas.

### Estructura del proyecto

La estructura de directorios del proyecto es la siguiente:

Claro, aquí está solo la sección de la estructura del proyecto en formato de texto para que puedas copiarla y pegarla directamente.

```
.
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── arep
    │   │           └── taller1
    │   │               └── talle1arep
    │   │                   └── HttpServer.java
    │   └── resources
    │       └── public
    │           └── index.html
    └── pom.xml
```

### Prerequisites
Debes tener instalado en tu equipo:  

- [Java 17 o superior](https://adoptium.net/)  
- [Apache Maven](https://maven.apache.org/) 

Verifica las versiones:
- $ java -version
- $ mvn -version


### Instalación
Clona este repositorio en tu máquina:
```
$ git clone https://github.com/Ttowers-09/Arep_Taller1_IvanTorres.git
```
Accedemos a la carpeta:
```
$ cd Talle1AREP
```

## Ejecución

Estando dentro de la carpeta Talle1AREP ejecutamos el siguiente  comando:
```
$ java -cp target/classes com.arep.taller1.talle1arep.HttpServer
```

### Finalizar la ejecución

En la consola ejecutamos la combinación de teclas: 

```
Windows: Ctrl + C
Mac: Comando + C
```

## Construido con:

- **Java Standard Library** - El proyecto está construido con clases de I/O y java.net de la librería estándar de Java.

- **Maven** - Se utiliza como herramienta de gestión de dependencias y compilación.

## Contribuir

En caso de querer contribuir envia una pull request especificando los cambios, en que afecta el código, el comportamiento del proyecto y su beneficio.

## Versionamiento

Usamos Git y GitHub para realizar el versionamiento del proyecto.

## Authors

* **Ivan Santiago Forero Torres** - *Trabajo inicial* - gitHub User: [Ttowers-09](https://github.com/PurpleBooth)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

