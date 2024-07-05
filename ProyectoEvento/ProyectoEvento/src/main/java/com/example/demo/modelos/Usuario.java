package com.example.demo.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Size(min=3, message="Por favor proporciona tu nombre.")
		private String nombre;
		@Size(min=3, message="Por favor proporcionar tu apellido.")
		private String apellido;
		@Email(message="Por favor proporciona un correo válido")
		private String correo;
		@Size(min=8, message="La contraseña necesita tener 8 caracteres")
		private String contraseña;
		
		private int admin;
		@ManyToMany(mappedBy = "usuarios")
	    private Set<Evento> eventos = new HashSet<>();

		@Temporal(TemporalType.DATE)
		@Column(name="fecha_creacion")
		private Date fechaCreacion;

		@Temporal(TemporalType.DATE)
		@Column(name="fecha_actualizacion")
		private Date fechaActualizacion;

		public Usuario() {}

		@PrePersist
		protected void onCreate() {
			this.fechaCreacion = new Date();
			this.fechaActualizacion = this.fechaCreacion;
		}

		@PreUpdate
		protected void onUpdate() {
			this.fechaActualizacion = new Date();
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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getContraseña() {
			return contraseña;
		}

		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}

		public Date getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public Date getFechaActualizacion() {
			return fechaActualizacion;
		}

		public void setFechaActualizacion(Date fechaActualizacion) {
			this.fechaActualizacion = fechaActualizacion;
		}

		public Set<Evento> getEventos() {
			return eventos;
		}

		public void setEventos(Set<Evento> eventos) {
			this.eventos = eventos;
		}

		public int getAdmin() {
			return admin;
		}

		public void setAdmin(int admin) {
			this.admin = admin;
		}
		
		


		
		
	}
