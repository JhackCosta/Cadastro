package com.jhack.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhack.myapi.Repository.UsuarioRepository;
import com.jhack.myapi.domain.Usuario;
import com.jhack.myapi.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	// mostrar um  usuario por Id
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID:" + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	//Retorna tudo de um Usuario;
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	// Altera usuario
	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
		
	}
	//Cria um usuario
	public Usuario create(Usuario obj) {
		obj.setId(null);
		
		return repository.save(obj);
	}
	
	//Deleta um usuario
	public void delete(Integer id) {
		
		findById(id);
		
		repository.deleteById(id);
	}
	
}
