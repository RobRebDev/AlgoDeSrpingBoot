package com.roberto.rebolledo.ejercicio03.Contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
