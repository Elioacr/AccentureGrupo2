package com.example.demo.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="eventos")
public class Evento {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nombre;
		private String descripcion;
		private String status;

		@ManyToMany
	    @JoinTable(
	        name = "evento_usuario",
	        joinColumns = @JoinColumn(name = "evento_id"),
	        inverseJoinColumns = @JoinColumn(name = "usuario_id")
	    )
		private Set<Usuario> usuarios = new HashSet<>();

		@Temporal(TemporalType.DATE)
		@Column(name="fecha_creacion")
		private Date fechaCreacion;

		@Temporal(TemporalType.DATE)
		@Column(name="fecha_termino")
		private Date fechaTermino;

		public Evento() {}

		@PrePersist
		protected void onCreate() {
			this.fechaCreacion = new Date();
			this.fechaTermino = this.fechaCreacion;
		}

		@PreUpdate
		protected void onUpdate() {
			this.fechaTermino = new Date();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public Date getFechaActualizacion() {
			return fechaTermino;
		}

		public void setFechaActualizacion(Date fechaActualizacion) {
			this.fechaTermino = fechaActualizacion;
		}

		public Date getFechaTermino() {
			return fechaTermino;
		}

		public void setFechaTermino(Date fechaTermino) {
			this.fechaTermino = fechaTermino;
		}

		public Set<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(Set<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		
		

		
	}
