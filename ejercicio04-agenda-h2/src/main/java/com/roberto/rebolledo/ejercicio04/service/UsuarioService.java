package com.roberto.rebolledo.ejercicio04.service;

import com.roberto.rebolledo.ejercicio04.models.Usuario;
import com.roberto.rebolledo.ejercicio04.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUsuario(Usuario u) {


        return usuarioRepository.save(u);
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = findUsuarioById(id);
        if (usuario != null) {
            usuario.setName(usuarioDetails.getName());
            usuario.setEmail(usuarioDetails.getEmail());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
