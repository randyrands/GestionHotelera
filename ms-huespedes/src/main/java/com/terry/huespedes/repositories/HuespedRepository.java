package com.terry.huespedes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terry.huespedes.models.Huesped;

@Repository
public interface HuespedRepository  extends JpaRepository<Huesped, Long>{
	//boolean existsByIdHuesped(Long idTipo);
	/*@Query(nativeQuery = true, value ="SELECT COUNT(*) FROM PRODUCTO_PROVEEDORES"
			+ " WHERE ID = :idProveedor")
	int exiexistsByIdProveedor(@Param("idProveedor")Long idProveedor);*/
}
