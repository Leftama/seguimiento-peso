package com.healthtrack;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Usar modo headless para entorno CI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu"); // Aunque ya no es obligatorio, puede ayudar
        options.addArguments("--disable-extensions");
        

       
        // Requiere tener ChromeDriver instalado y en el PATH
        driver = new ChromeDriver();
    }

    @Test
    void testActualizarPesoDesdeUI() {
        // Reemplaza con la URL real de tu app
        driver.get("http://localhost:4567");

        // Busca el campo para ingresar el nuevo peso
        WebElement inputPeso = driver.findElement(By.id("peso"));
        inputPeso.clear();
        inputPeso.sendKeys("75.5");

        // Presiona el botón para actualizar
        WebElement botonActualizar = driver.findElement(By.id("btnActualizar"));
        botonActualizar.click();

        // Verifica si el valor actualizado aparece correctamente
        WebElement pesoActualizado = driver.findElement(By.id("pesoActual"));
        assertEquals("75.5 kg", pesoActualizado.getText());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

