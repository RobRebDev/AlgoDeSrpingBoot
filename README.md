# AlgoDeSrpingBoot

## Relación OneToMany y ManyToOne en Spring Boot

Estas anotaciones se usan para definir relaciones entre entidades en una base de datos usando JPA/Hibernate.

### ¿Qué significan?

- **@OneToMany**: Una entidad tiene muchos elementos de otra entidad. Ejemplo: Un autor tiene muchos libros.
- **@ManyToOne**: Muchos elementos de una entidad pertenecen a una sola instancia de otra entidad. Ejemplo: Muchos libros pertenecen a un autor.

### Ejemplo básico

Supongamos que tenemos dos entidades: `Autor` y `Libro`.

#### 1. Entidad Autor

```java
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación: Un autor tiene muchos libros
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
}
```

#### 2. Entidad Libro

```java
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    // Relación: Muchos libros tienen un autor
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
```

### Opciones comunes de @OneToMany y @ManyToOne

#### @OneToMany

- **mappedBy**: Indica el campo en la entidad "hija" que mapea la relación.
- **cascade**: Permite definir qué operaciones (persist, merge, remove, etc.) se propagan a los hijos. Ejemplo: `cascade = CascadeType.ALL`
- **fetch**: Define cómo se cargan los datos relacionados. Por defecto es `FetchType.LAZY` (se carga bajo demanda), pero puede ser `FetchType.EAGER` (se carga inmediatamente).
- **orphanRemoval**: Si es `true`, elimina los hijos huérfanos cuando se eliminan de la colección.

Ejemplo:
```java
@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
private List<Libro> libros;
```

#### @ManyToOne

- **fetch**: Igual que en `@OneToMany`, puede ser `FetchType.LAZY` o `FetchType.EAGER`.
- **optional**: Si es `false`, la relación es obligatoria (no puede ser null).
- **cascade**: Menos común, pero se puede usar para propagar operaciones.

Ejemplo:
```java
@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name = "autor_id")
private Autor autor;
```

### Explicación

- En `Autor`, usamos `@OneToMany` para indicar que un autor puede tener varios libros. El atributo `mappedBy` indica el nombre del campo en la entidad `Libro` que representa la relación inversa.
- En `Libro`, usamos `@ManyToOne` para indicar que cada libro tiene un solo autor. `@JoinColumn` define la columna que almacena la referencia al autor.

### ¿Qué más necesitas?

- Las entidades deben tener sus getters/setters.
- Puedes usar repositorios Spring Data JPA para guardar y consultar datos.
- Recuerda inicializar las listas (por ejemplo, `libros = new ArrayList<>();`) en el constructor si lo necesitas.

### Resumen

- Usa `@OneToMany` en la entidad "padre" y `@ManyToOne` en la entidad "hija".
- El campo con `@ManyToOne` es el que tiene la clave foránea en la base de datos.

---
