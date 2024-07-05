package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
	List<Usuario> findAll();
	Usuario findByCorreo(String correo);
}