package com.healthtrack;

import static spark.Spark.*;

public class App {
    private static double peso = 70.0;

    public static void main(String[] args) {
        port(4567); // Puerto por defecto

        staticFiles.location("/public"); // Para servir archivos estáticos desde resources/public

        get("/peso", (req, res) -> String.format("%.1f kg", peso));

        post("/actualizar", (req, res) -> {
            String nuevoPeso = req.queryParams("peso");
            peso = Double.parseDouble(nuevoPeso);
            res.redirect("/");
            return null;
        });
    }
}
