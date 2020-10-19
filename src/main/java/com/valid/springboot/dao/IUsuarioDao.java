/**
 * 
 */
package com.valid.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.valid.springboot.entity.Usuario;

/**
 * @author POLO
 *
 */
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
