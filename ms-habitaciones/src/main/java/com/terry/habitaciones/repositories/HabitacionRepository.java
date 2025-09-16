package com.terry.habitaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terry.habitaciones.models.Habitacion;






@Repository
public interface HabitacionRepository  extends JpaRepository<Habitacion, Long>{
	//boolean existsByIdTipo(Long idTipo);
	/*@Query(nativeQuery = true, value ="SELECT COUNT(*) FROM PRODUCTO_PROVEEDORES"
			+ " WHERE ID = :idProveedor")
	int exiexistsByIdProveedor(@Param("idProveedor")Long idProveedor);*/
}
