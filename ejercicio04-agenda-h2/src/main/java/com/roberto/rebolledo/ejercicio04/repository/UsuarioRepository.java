package com.roberto.rebolledo.ejercicio04.repository;

import com.roberto.rebolledo.ejercicio04.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
