package com.orangetalents.projeto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.projeto.api.model.Endereco;
import com.orangetalents.projeto.api.model.Usuario;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByUsuario(Usuario usuario);

}
