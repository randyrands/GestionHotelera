package com.terry.habitaciones.mappers;

import org.springframework.stereotype.Component;

import com.terry.commons.dto.HabitacionRequest;
import com.terry.commons.dto.HabitacionResponse;
import com.terry.commons.mappers.CommonMapper;
import com.terry.habitaciones.models.Habitacion;




@Component
public class HabitacionMapper extends CommonMapper<HabitacionRequest, HabitacionResponse, Habitacion> {
	
	@Override
	public HabitacionResponse entityToResponse(Habitacion entity) {
		if(entity == null) {
			return null;
		}
		
			return new HabitacionResponse(
					entity.getIdHabitacion(),
					entity.getNumero(),
					entity.getTipo(),
					entity.getDescripcion(),
					entity.getPrecio(),
					entity.getCapacidad(),
					entity.getEstado()
					);
	}
		
	@Override
	public Habitacion requestToEntity(HabitacionRequest request) {
		if(request == null) {
			return null;
		}
		Habitacion habitacion =new Habitacion();
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setEstado(request.estado());
		return habitacion;
	}

}
