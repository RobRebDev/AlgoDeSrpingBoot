
# Guía básica de Spring Boot CRUD con Swagger

Este proyecto es una aplicación CRUD para gestionar contactos usando **Spring Boot**, **JPA**, **H2** y **Swagger**.



## 1\. Modelo: Contact

El modelo representa la estructura de datos que se almacena en la base de datos.

**Archivo:** `Contact.java`

**Anotaciones principales:**
- `@Entity`: Marca la clase como una entidad JPA.
- `@Id`: Indica el campo clave primaria.
- Lombok: `@AllArgsConstructor`, `@NoArgsConstructor`, `@Getter`, `@Setter` generan constructores y métodos automáticamente.

**Ejemplo real:**
```java
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {
    @Id
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
}
```

2\. Repositorio

El repositorio permite acceder y manipular los datos de la entidad.

**Archivo:** `ContactRepository.java`

**Anotaciones principales:**
- `@Repository`: Marca la interfaz como repositorio (opcional si extiende `JpaRepository`).

**Ejemplo real:**
```java
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
```

---

## 3\. Servicio

El servicio contiene la lógica de negocio y usa el repositorio para acceder a los datos.

**Archivo:** `ContactService.java`

**Anotaciones principales:**
- `@Service`: Marca la clase como servicio de Spring.

**Ejemplo real:**
```java
@Service
public class ContactService {
    private final ContactRepository contactRepository;
    // Métodos para crear, leer, actualizar y eliminar contactos
}
```

---

## 4\. Controlador

El controlador expone los endpoints HTTP para interactuar con la aplicación.

**Archivo:** `ContactController.java`

**Anotaciones principales:**
- `@RestController`: Marca la clase como controlador REST.
- `@RequestMapping`: Define la ruta base.
- `@PostMapping`, `@GetMapping`, `@PutMapping`, `@DeleteMapping`: Definen los métodos HTTP.

**Ejemplo real:**
```java
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    // Endpoints para CRUD de contactos
}
```

---

## 5\. Documentación con Swagger

Swagger permite visualizar y probar la API desde una interfaz web.

**Dependencia en `pom.xml`:**
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.13</version>
</dependency>
```

**Configuración en `application.properties`:**
```
springdoc.swagger-ui.path=/swagger-ui-custom.html
```

**¿Cómo acceder?**

Levanta la aplicación y entra en [http://localhost:8080/swagger-ui-custom.html](http://localhost:8080/swagger-ui-custom.html) para ver y probar los endpoints.

---

## 6\. Base de datos en memoria

Se utiliza H2, una base de datos en memoria, ideal para pruebas y desarrollo.

---

**Resumen de capas:**
- **Modelo:** Estructura de datos (`Contact`)
- **Repositorio:** Acceso a la base de datos
- **Servicio:** Lógica de negocio
- **Controlador:** Endpoints HTTP
- **Swagger:** Documentación y pruebas de la API

---

Este README te servirá como guía para entender la estructura básica de un proyecto Spring Boot CRUD con Swagger usando la entidad `Contact`.
```