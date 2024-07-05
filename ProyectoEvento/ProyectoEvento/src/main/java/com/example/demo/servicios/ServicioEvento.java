package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Evento;
import com.example.demo.repositorio.RepositorioEvento;



@Service
public class ServicioEvento {
	@Autowired
	private final RepositorioEvento repositorioEvento;

	public ServicioEvento(RepositorioEvento repositorioEvento) {
		this.repositorioEvento = repositorioEvento;
	}

	public Evento insertarEvento(Evento eventoNueva) {
		return this.repositorioEvento.save(eventoNueva);
	}
}
