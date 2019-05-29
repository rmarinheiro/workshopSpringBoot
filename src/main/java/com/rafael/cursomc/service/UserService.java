package com.rafael.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.cursomc.domain.User;
import com.rafael.cursomc.domain.dto.UserDTO;
import com.rafael.cursomc.repository.UserRepository;
import com.rafael.cursomc.service.exceptions.ObjectFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String Id) {
		findById(Id);
		repo.deleteById(Id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}

}
