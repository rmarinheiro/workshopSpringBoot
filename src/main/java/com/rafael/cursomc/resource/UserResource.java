package com.rafael.cursomc.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.cursomc.domain.User;
import com.rafael.cursomc.domain.dto.UserDTO;
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

	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		
		List<User> list =  userService.findAll();
		
		return ResponseEntity.ok(list);
		
	}*/
	
@RequestMapping(method = RequestMethod.GET)	
public ResponseEntity<List<UserDTO>> findAll(){
		
		
		List<User> list =  userService.findAll();
		List<UserDTO>listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
				
		
		return ResponseEntity.ok(listDTO);
		
	}

@RequestMapping( value = "/{id}" ,method = RequestMethod.GET)	
public ResponseEntity <UserDTO> findById( @PathVariable String id){
	
	User obj = userService.findById(id);
	
			
	
	return ResponseEntity.ok().body(new UserDTO(obj));
	
}

@RequestMapping( value = "/{id}" ,method = RequestMethod.DELETE)	
public ResponseEntity <UserDTO> delete( @PathVariable String id){
	userService.delete(id);
	
	return ResponseEntity.noContent().build();
	
}

@RequestMapping(method = RequestMethod.POST)	
public ResponseEntity <Void> insert( @RequestBody UserDTO objDTO){
	
	User obj = userService.fromDTO(objDTO);
	obj = userService.insert(obj);
	
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	
	
}
	
}
