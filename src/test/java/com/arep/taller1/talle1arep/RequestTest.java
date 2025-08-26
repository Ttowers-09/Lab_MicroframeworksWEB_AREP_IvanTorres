package com.arep.taller1.talle1arep;

import org.junit.Test;
import static org.junit.Assert.*;

public class RequestTest {
    @Test
    public void testGetValuesFromQuery() {
        Request req = new Request("/hello", "name=Pedro&age=20", "GET", null);
        assertEquals("Pedro", req.getValues("name"));
        assertEquals("20", req.getValues("age"));
        assertNull(req.getValues("notfound"));
    }

    @Test
    public void testGetValuesFromBody() {
        Request req = new Request("/hello", null, "POST", "name=Maria&city=Bogota");
        assertEquals("Maria", req.getValues("name"));
        assertEquals("Bogota", req.getValues("city"));
        assertNull(req.getValues("notfound"));
    }
}
