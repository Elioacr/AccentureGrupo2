package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Evento;
import com.example.demo.repositorio.RepositorioEvento;

@Controller
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private RepositorioEvento repositorioEvento;

    @GetMapping
    public List<Evento> getAllEventos() {
        return repositorioEvento.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Optional<Evento> evento = repositorioEvento.findById(id);
        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return repositorioEvento.save(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Optional<Evento> optionalEvento = repositorioEvento.findById(id);
        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();
            evento.setNombre(eventoDetails.getNombre());
            evento.setDescripcion(eventoDetails.getDescripcion());
            evento.setFechaCreacion(eventoDetails.getFechaCreacion());
            return ResponseEntity.ok(repositorioEvento.save(evento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        Optional<Evento> evento = repositorioEvento.findById(id);
        if (evento.isPresent()) {
        	repositorioEvento.delete(evento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}