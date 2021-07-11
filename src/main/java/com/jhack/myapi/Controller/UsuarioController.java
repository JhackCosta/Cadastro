package com.jhack.myapi.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhack.myapi.domain.Usuario;
import com.jhack.myapi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService controller;
	
	@GetMapping(value = "/{id}") // mostrar por ID
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		Usuario obj = this.controller.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping //Mostrar Todos
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = controller.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PutMapping(value = "/{id}") //Alterar Dados
	public ResponseEntity <Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
		Usuario newObj = controller.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	@PostMapping //Adicionar Novo Usuario
	public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
		Usuario newObj = controller.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}") //Deletar usuario
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		controller.delete(id);
		return ResponseEntity.noContent().build();
	}
}
