# AlgoDeSrpingBootLa aplicación estará disponible en `http://localhost:8080`.

## Ejemplo de uso de @RequestParam y @PathVariable

Supón que tienes un controlador con dos métodos:

- `@RequestParam`: Recibe parámetros desde la URL como query string.  
  Ejemplo: `GET /hello?name=Juan`
- `@PathVariable`: Recibe parámetros como parte de la ruta.  
  Ejemplo: `GET /hello/Juan`

### Ejemplo de código

```java
@RestController
public class HelloController {

    // Usando @RequestParam: el parámetro se pasa como query string
    // Ejemplo: /hello?name=Juan
    @GetMapping("/hello")
    public String helloWithRequestParam(@RequestParam String name) {
        return "Hola " + name;
    }

    // Usando @PathVariable: el parámetro se pasa en la ruta
    // Ejemplo: /hello/Juan
    @GetMapping("/hello/{name}")
    public String helloWithPathVariable(@PathVariable String name) {
        return "Hola " + name;
    }
}