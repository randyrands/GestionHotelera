package com.terry.authorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terry.authorization.entities.Rol;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{
	
	Optional<Rol> findByNombre(String nombre);

}