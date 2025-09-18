package com.terry.oauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terry.oauth.entities.Rol;
import java.util.Optional;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	
	Optional<Rol> findByNombre(String nombre);

}
