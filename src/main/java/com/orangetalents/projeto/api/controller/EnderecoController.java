package com.orangetalents.projeto.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.orangetalents.projeto.api.model.Endereco;
import com.orangetalents.projeto.api.model.Usuario;
import com.orangetalents.projeto.api.repository.EnderecoRepository;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@CrossOrigin()
	@RequestMapping(value = "/endereco", method =  RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public Endereco Post(@Validated @RequestBody Endereco endereco) {

        return enderecoRepository.save(endereco);
        
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/endereco-usuario/{usuario_id}", method = RequestMethod.GET)
	public List<Endereco> GetByIdUsuario(@PathVariable(value = "usuario_id") long usuarioId){
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		
		List<Endereco> endereco = enderecoRepository.findByUsuario(usuario);

		return endereco;
		
    }
	
	
	@CrossOrigin()
	@RequestMapping(value = "/enderecos", method = RequestMethod.GET)
	public List<Endereco> Get(){
		return enderecoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id){
        Optional<Endereco> usuario = enderecoRepository.findById(id);
        if(usuario.isPresent()) {
            return new ResponseEntity<Endereco>(usuario.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/endereco/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Endereco enderecoAtualizado) {
        Optional<Endereco> usuarioAntigo = enderecoRepository.findById(id);
        if(usuarioAntigo.isPresent()){
        	enderecoRepository.save(enderecoAtualizado);
            return new ResponseEntity<Endereco>(enderecoAtualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@CrossOrigin()
	@RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isPresent()){
        	enderecoRepository.delete(endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
