package com.terry.authorization.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name  = "ROLES_OAUTH")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="ROLES_SEQ")
	@SequenceGenerator(name ="ROLES_SEQ", sequenceName = "ROLES_SEQ", allocationSize =1)
	@Column(name = "ID_ROL")
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false, length = 15, unique = true)
	private String nombre;
	
	public Long getId() {  // ✅ CORREGIDO: Cambié de private a public
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}