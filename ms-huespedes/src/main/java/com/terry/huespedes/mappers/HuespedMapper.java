package com.terry.huespedes.mappers;

import org.springframework.stereotype.Component;

import com.terry.commons.dto.HuespedRequest;
import com.terry.commons.dto.HuespedResponse;
import com.terry.commons.mappers.CommonMapper;
import com.terry.huespedes.models.Huesped;




@Component
public class HuespedMapper extends CommonMapper<HuespedRequest, HuespedResponse, Huesped> {
	
	@Override
	public HuespedResponse entityToResponse(Huesped entity) {
		if(entity == null) {
			return null;
		}
		
			return new HuespedResponse(
					entity.getId(),
					entity.getNombre(),
					entity.getApellido(),
					entity.getEmail(),
					entity.getTelefono(),
					entity.getDocumento(),
					entity.getNacionalidad()
					);
	}
		
	@Override
	public Huesped requestToEntity(HuespedRequest request) {
		if(request == null) {
			return null;
		}
		Huesped huesped =new Huesped();
		huesped.setNombre(request.nombre());
		huesped.setApellido(request.apellido());
		huesped.setEmail(request.email());
		huesped.setTelefono(request.telefono());
		huesped.setDocumento(request.documento());
		huesped.setNacionalidad(request.nacionalidad());
		return huesped;
	}

}
