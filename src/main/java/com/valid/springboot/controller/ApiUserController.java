package com.valid.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.valid.springboot.entity.Usuario;
import com.valid.springboot.service.IUsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiUserController {

	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/list")
	public List<Usuario> index(){
	
		return userService.findAll();
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario user) {
		Usuario userCreated = userService.save(user);
        return new ResponseEntity<Usuario>(userCreated, HttpStatus.CREATED);				
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario user, @PathVariable Long id) {
		
		Usuario usuarioAct = userService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		try {
			usuarioAct.setProcesado(user.isProcesado());
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("cliente", usuarioAct);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
