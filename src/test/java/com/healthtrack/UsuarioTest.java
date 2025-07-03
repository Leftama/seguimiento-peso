package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UsuarioTest {

    @Test
    void testGetNombre() {
        Usuario u = new Usuario("Carlos", 75.5);
        assertEquals("Carlos", u.getNombre());
    }

    @Test
    void testGetPeso() {
        Usuario u = new Usuario("Lucía", 55.0);
        assertEquals(55.0, u.getPeso(), 0.01);
    }
    @Test
    void testActualizarPeso() {
        Usuario usuario = new Usuario("Carlos", 70.0);
        usuario.actualizarPeso(72.5);
        assertEquals(72.5, usuario.getPeso(), 0.01);
    }

    @Test
    void testActualizarPesoNegativo() {
        Usuario usuario = new Usuario("Ana", 60.0);
        usuario.actualizarPeso(-5.0);
        assertEquals(-5.0, usuario.getPeso(), 0.01); // Se debe validar si se acepta esto o lanzar excepción
    }

    @Test
    void testMostrarInformacion() {
        Usuario u = new Usuario("María", 68.0);

        // Redirigir System.out a un stream temporal
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        // Ejecutar el método que imprime
        u.mostrarInformacion();

        // Restaurar salida original
        System.setOut(salidaOriginal);

        // Validar contenido impreso
        String salida = salidaCapturada.toString().trim();
        assertTrue(salida.contains("Usuario: María"));
        assertTrue(salida.contains("Peso Actual: 68.0"));
    }
}
