/**
 * 
 */
package com.valid.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valid.springboot.dao.IUsuarioDao;
import com.valid.springboot.entity.Usuario;

/**
 * @author POLO
 *
 */
@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll(){
		return (List<Usuario>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario save(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Usuario findById(Long id) {
		
		return dao.findById(id).orElse(null);
		
	}
	
	

}
