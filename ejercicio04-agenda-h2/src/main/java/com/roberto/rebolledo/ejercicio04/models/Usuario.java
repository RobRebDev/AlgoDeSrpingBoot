package com.roberto.rebolledo.ejercicio04.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
// Clase Usuario con relación uno-a-muchos hacia Task
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // @ToString.Exclude evita que la lista de tareas se incluya en el método toString generado por Lombok,
    // previniendo bucles infinitos y mejorando la legibilidad.
    @ToString.Exclude
    // @OneToMany establece la relación uno-a-muchos con Task.
    // mappedBy: indica que el dueño de la relación es el campo "usuario" en Task.
    // cascade: todas las operaciones (persist, merge, remove, etc.) se propagan de Usuario a Task.
    // orphanRemoval: si se elimina una Task de la lista, también se elimina de la base de datos.
    // fetch: por defecto es LAZY, las tareas se cargan solo cuando se accede a ellas.
    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();

}
