package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelos.Evento;

@Repository
public interface RepositorioEvento extends CrudRepository<Evento, Long> {
	List<Evento> findAll();
}