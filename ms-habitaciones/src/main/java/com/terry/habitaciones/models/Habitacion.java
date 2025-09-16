package com.terry.habitaciones.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "HABITACIONES")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="HABITACIONES_SEQ")
	@SequenceGenerator(name ="HABITACIONES_SEQ", sequenceName = "HABITACIONES_SEQ", allocationSize =1)
	
	@Column(name = "ID")
	private Long id;
	
	
	@Column(name ="NUMERO", unique =true)
	private Long numero;

	
	@Column (name ="TIPO")
	private String tipo;
	
	@Column(name= "DESCRIPCION")
	private String descripcion;


	@Column(name= "PRECIO")
	private Double precio;

	@NotNull
	@Column(name= "CAPACIDAD")
	private Long capacidad;
	
	@Column(name= "ESTADO")
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	


}
