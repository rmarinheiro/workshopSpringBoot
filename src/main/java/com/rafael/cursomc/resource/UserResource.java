package com.rafael.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.cursomc.domain.User;
import com.rafael.cursomc.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria","Maria@gmail.com");
		User joao = new User("2", "Joao","Joao@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao,maria));
		
		return ResponseEntity.ok(list);
		
	}*/

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		
		List<User> list =  userService.findAll();
		
		return ResponseEntity.ok(list);
		
	}
	
}
