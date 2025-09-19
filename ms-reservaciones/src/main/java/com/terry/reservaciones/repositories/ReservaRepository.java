package com.terry.reservaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.terry.reservaciones.models.Reserva;

import feign.Param;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	boolean existsByIdHuesped(Long idHuesped); 
	
	
	@Query(nativeQuery = true, value ="SELECT COUNT(*) FROM RESERVA_HABITACIONES"
			+ " WHERE ID_RESERVACION = :idHabitacion")
	int existsByIdHabitacion(@Param("idHabitacion")Long idHabitacion);
	
	
	
}
