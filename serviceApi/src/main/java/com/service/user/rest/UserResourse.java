package com.service.user.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.service.user.dao.UserRepository;
import com.service.user.entitys.User;


@RestController
@RequestMapping("users")
public class UserResourse {
	
	@Autowired	
	private UserRepository userRepository;
	
	
	@GetMapping                                 //obtiene una lista de usuarios
	public ResponseEntity<List<User>> getUsers(){
		List<User> users= userRepository.findAll();
	    return ResponseEntity.ok(users); 
		
	}
	
	@RequestMapping(value="{id}")                   // user/{Id} Obtine un usuario dado un id.
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
		Optional<User>optionalUser = userRepository.findById(userId);
	    if(optionalUser.isPresent()) {
	    	return ResponseEntity.ok(optionalUser.get());
	    }else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	@PostMapping                                   // crea un usuario pasando por parametro
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newuser = userRepository.save(user);
		return ResponseEntity.ok(newuser);
	}
	
	 @DeleteMapping(value="{id}")                   // elimina un usuario pasando un id
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId){
		userRepository.deleteById(userId);
		return ResponseEntity.ok(null);
	}
	
	
	@PutMapping                       // actualiza un usuario pasandole el usuario a actualizar
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		Optional<User>optionalUser = userRepository.findById(user.getId());
	    if(optionalUser.isPresent()) {
	    	User userupdate = optionalUser.get();
	    	userupdate.setName(user.getName());
	    	userupdate.setDateBirth(user.getDateBirth());
	    	userRepository.save(userupdate);
	    	return ResponseEntity.ok(userupdate);
	    }else {
	    	return ResponseEntity.noContent().build();
	    }
	}
}
