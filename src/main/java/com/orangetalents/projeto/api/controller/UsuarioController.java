package com.orangetalents.projeto.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.projeto.api.model.Usuario;
import com.orangetalents.projeto.api.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@CrossOrigin()
	@RequestMapping(value = "/usuario", method =  RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public Usuario Post(@Valid @RequestBody Usuario usuario) {

		return usuarioRepository.save(usuario);
		
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> Get(){
		return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
        	return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        }else {

        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/usuario/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioAntigo = usuarioRepository.findById(id);
        if(usuarioAntigo.isPresent()){
        	usuarioRepository.save(usuarioAtualizado);
            return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
        	usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
