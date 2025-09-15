package com.roberto.rebolledo.ejercicio02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // Utiliza @PathVariable para obtener valores directamente de la ruta (URL).
    // Ejemplo: /hello/Roberto -> hello = "Roberto"
    @GetMapping("/hello/{hello}")
    public String helloPathVariable(@PathVariable String hello) {
        return "Hello "+ hello;

    }

    // Utiliza @RequestParam para obtener valores de los parámetros de la consulta (query string).
    // Ejemplo: /hello?name=Roberto -> name = "Roberto"
    @GetMapping("/hello")
    public String helloRequestParam(@RequestParam(value = "name") String name) {
        return "Hello World";

    }


}
