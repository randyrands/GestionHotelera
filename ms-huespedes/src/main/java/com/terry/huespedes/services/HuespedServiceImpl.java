package com.terry.huespedes.services;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.commons.dto.HuespedRequest;
import com.terry.commons.dto.HuespedResponse;
import com.terry.huespedes.mappers.HuespedMapper;
import com.terry.huespedes.models.Huesped;
import com.terry.huespedes.repositories.HuespedRepository;


@Service
@Transactional
public class HuespedServiceImpl implements HuespedService {

	
	private final HuespedMapper huespedMapper;
	private final HuespedRepository huespedRepository;
	
	
	


	public HuespedServiceImpl(HuespedMapper huespedMapper, HuespedRepository huespedRepository) {
		super();
		this.huespedMapper = huespedMapper;
		this.huespedRepository = huespedRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HuespedResponse> listar() {
		
		return huespedRepository.findAll().stream()
				.map(huespedMapper::entityToResponse).toList();
	}

	@Override
	public HuespedResponse obtenerPorId(Long id) {
	
		return huespedMapper.entityToResponse(huespedRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Huesped no encontrado con el id: "+id)));
			
	}

	@Override
	public HuespedResponse insertar(HuespedRequest request) {

		return huespedMapper.entityToResponse(huespedRepository.save(huespedMapper.requestToEntity(request)));
	
	}

	@Override
	public HuespedResponse actualizar(HuespedRequest request, Long id) {
		
		Huesped huesped = huespedRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Huesped no encontrado con el id: "+ id));
		huesped.setNombre(request.nombre());
		huesped.setApellido(request.apellido());
		huesped.setEmail(request.email());
		huesped.setTelefono(request.telefono());
		huesped.setDocumento(request.documento());
		huesped.setNacionalidad(request.nacionalidad());
		
				return huespedMapper.entityToResponse(huesped);
	}

	@Override
	public HuespedResponse eliminar(Long id) {
		
		Huesped huesped = huespedRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Huesped no encontrado con el id: "+ id));
		
			huespedRepository.deleteById(id);
			return huespedMapper.entityToResponse(huesped);
	}
	

}
