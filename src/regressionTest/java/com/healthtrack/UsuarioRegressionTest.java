package com.healthtrack;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsuarioRegressionTest {

    @BeforeAll
    static void configurarRestAssured() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4567;
    }

    @Test
    @Order(1)
    void testPesoInicialEs70() {
        given().
        when().
            get("/peso").
        then().
            statusCode(200).
            body(containsString("70.0"));
    }

    @Test
    @Order(2)
    void testActualizarPesoFunciona() {
        given().
            formParam("peso", "75.0").
        when().
            post("/actualizar").
        then().
            statusCode(302); // redirige al home

        // Verificar el nuevo peso
        given().
        when().
            get("/peso").
        then().
            statusCode(200).
            body(containsString("75.0"));
    }
}
