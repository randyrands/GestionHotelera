package com.terry.authorization.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name  = "USUARIOS_OAUTH")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="USUARIOS_SEQ")
	@SequenceGenerator(name ="USUARIOS_SEQ", sequenceName = "USUARIOS_SEQ", allocationSize =1)
	
	@Column(name = "ID_USUARIO")
	private Long id;
	
	@Column(name = "USERNAME", nullable = false, length = 20, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="USUARIOS_ROLES",	
		joinColumns =@JoinColumn(name="ID_USUARIO"),      // ✅ CORREGIDO
		inverseJoinColumns = @JoinColumn(name="ID_ROL")   // ✅ AGREGADO
	)
	private Set<Role> roles;

	// ... resto de getters y setters permanecen igual
}