package com.orangetalents.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.projeto.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
