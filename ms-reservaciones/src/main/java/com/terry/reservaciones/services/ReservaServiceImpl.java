package com.terry.reservaciones.services;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.commons.clients.HabitacionClient;
import com.terry.commons.clients.HuespedClient;
import com.terry.commons.dto.HabitacionResponse;
import com.terry.commons.dto.HuespedResponse;
import com.terry.commons.dto.ReservaRequest;
import com.terry.commons.dto.ReservaResponse;
import com.terry.reservaciones.mappers.ReservaMapper;
import com.terry.reservaciones.models.Habitacion;
import com.terry.reservaciones.models.Reserva;
import com.terry.reservaciones.repositories.ReservaRepository;



@Service
@Transactional 
public class ReservaServiceImpl implements ReservaService{
	
	
	private final ReservaMapper  reservaMapper;
	private final ReservaRepository reservaRepository;
	private final HabitacionClient habitacionClient;
	private final HuespedClient huespedClient;


	
	public ReservaServiceImpl(ReservaMapper reservaMapper, ReservaRepository reservaRepository,
			HabitacionClient habitacionClient, HuespedClient huespedClient) {
		this.reservaMapper = reservaMapper;
		this.reservaRepository = reservaRepository;
		this.habitacionClient = habitacionClient;
		this.huespedClient = huespedClient;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReservaResponse> listar() {
		return reservaRepository.findAll().stream()
				.map(reservaMapper::entityToResponse).toList();
	}

	@Override
	public ReservaResponse obtenerPorId(Long id) {
		return reservaMapper.entityToResponse(reservaRepository.findById(id).orElseThrow(
				
				()-> new NoSuchElementException("Reserva no encontrado con el id: "+id)));
	}

	@Override
	public ReservaResponse insertar(ReservaRequest request) {
		
		return reservaMapper.entityToResponse(reservaRepository.save(reservaMapper.requestToEntity(request)));
		
	}

	@Override
	public ReservaResponse actualizar(ReservaRequest request, Long id) {
		Reserva reserva = reservaRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Reserva no encontrada con el id: "+ id));
		
		reserva.setFecha_entrada(request.fecha_entrada());
		reserva.setFecha_salida(request.fecha_salida());
		reserva.setNoches(request.noches());
		reserva.setTotal(request.total());
		reserva.setEstado(request.estado());
		
		HuespedResponse huespedResponse = huespedClient.getHuespedById(request.idHuesped());
		reserva.setIdHuesped(huespedResponse.id());
		
		Set<Habitacion> habitaciones = new HashSet<>();
		request.idHabitaciones().forEach(idHab ->{
			HabitacionResponse habitacionResponse = habitacionClient.getHabitacionXById(idHab);
			Habitacion habitacion = new Habitacion();
			habitacion.setId(habitacionResponse.id());
			habitaciones.add(habitacion);
		});

		reserva.setHabitaciones(habitaciones);
		
		
		return reservaMapper.entityToResponse(reservaRepository.save(reserva));	
				
	}

	@Override
	@Transactional
	public ReservaResponse eliminar(Long id) {
		Reserva reserva = reservaRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Reserva no encontrado con el id: "+ id));
			reservaRepository.delete(reserva);
			return reservaMapper.entityToResponse(reserva);
	}

	

	@Override
	@Transactional(readOnly = true)
	public boolean habitacionIsPresent(Long id) {
		return reservaRepository.existsByIdHabitacion(id)>0;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean huespedIsPresent(Long id) {
		// TODO Auto-generated method stub
		return reservaRepository.existsByIdHuesped(id);
	}

	
}
