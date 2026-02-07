package org.example;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        // Railway o Heroku asignan el puerto dinámicamente.
        // Si no detecta uno, usa el 8080 por defecto.
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        Javalin app = Javalin.create().start(port);

        // Este es el servicio que el cliente de tu Mac consultará
        app.get("/cloud-check", ctx -> {
            ctx.json("{\"status\": \"online\", \"server\": \"Railway Cloud\", \"dev\": \"YourName\"}");
        });
    }
}