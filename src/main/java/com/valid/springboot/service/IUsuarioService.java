package com.valid.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.valid.springboot.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);

	public Usuario findById(Long id);

}
