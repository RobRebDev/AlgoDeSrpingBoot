package com.roberto.rebolledo.ejercicio04.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

// Clase Task que representa una tarea asociada a un usuario
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    // @ManyToOne indica que muchas tareas pueden estar asociadas a un solo usuario.
    // optional = false: la relación es obligatoria, una tarea siempre debe tener un usuario.
    // @JoinColumn define la columna en la base de datos que almacena la referencia al usuario.
    // name: nombre de la columna en la tabla Task.
    // nullable = false: la columna no puede ser nula.
    // @JsonIgnore evita que el usuario se serialice en la respuesta JSON, previniendo bucles y mejorando la seguridad.
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

}