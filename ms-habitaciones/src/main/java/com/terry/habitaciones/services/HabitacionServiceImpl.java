package com.terry.habitaciones.services;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.commons.dto.HabitacionRequest;
import com.terry.commons.dto.HabitacionResponse;
import com.terry.habitaciones.mappers.HabitacionMapper;
import com.terry.habitaciones.models.Habitacion;
import com.terry.habitaciones.repositories.HabitacionRepository;






@Service
@Transactional
public class HabitacionServiceImpl implements HabitacionService {

	
	private final HabitacionMapper habitacionMapper;
	private final HabitacionRepository habitacionRepository;
	
	


	public HabitacionServiceImpl(HabitacionMapper habitacionMapper, HabitacionRepository habitacionRepository) {
		super();
		this.habitacionMapper = habitacionMapper;
		this.habitacionRepository = habitacionRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HabitacionResponse> listar() {
		
		return habitacionRepository.findAll().stream()
				.map(habitacionMapper::entityToResponse).toList();
	}

	@Override
	public HabitacionResponse obtenerPorId(Long id) {
	
		return habitacionMapper.entityToResponse(habitacionRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Habitacion no encontrado con el id: "+id)));
			
	}

	@Override
	public HabitacionResponse insertar(HabitacionRequest request) {

		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacionMapper.requestToEntity(request)));
	
	}

	@Override
	public HabitacionResponse actualizar(HabitacionRequest request, Long id) {
		
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Habitacion no encontrado con el id: "+ id));
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setEstado(request.estado());
		
				return habitacionMapper.entityToResponse(habitacion);
	}

	@Override
	public HabitacionResponse eliminar(Long id) {
		
		Habitacion habitacion = habitacionRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Habitacion no encontrado con el id: "+ id));
		
			habitacionRepository.deleteById(id);
			return habitacionMapper.entityToResponse(habitacion);
	}

	@Override
	public boolean tipoIsPresent(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	//Verificacion de Commit

}
