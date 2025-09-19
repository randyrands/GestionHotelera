package com.terry.reservaciones.models;


import jakarta.persistence.Embeddable;

@Embeddable
public class Habitacion {
	private Long id;
	private Integer numero;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
}
