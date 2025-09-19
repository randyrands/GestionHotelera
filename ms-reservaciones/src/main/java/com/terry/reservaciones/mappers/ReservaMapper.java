package com.terry.reservaciones.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.terry.commons.dto.HabitacionResponse;
import com.terry.commons.dto.HuespedResponse;
import com.terry.commons.dto.ReservaRequest;
import com.terry.commons.dto.ReservaResponse;
import com.terry.commons.mappers.CommonMapper;
import com.terry.commons.clients.HabitacionClient;
import com.terry.commons.clients.HuespedClient;
import com.terry.reservaciones.models.Habitacion;
import com.terry.reservaciones.models.Reserva;

@Component
public class ReservaMapper extends CommonMapper<ReservaRequest, ReservaResponse, Reserva> {

    private final HuespedClient huespedClient;
    private final HabitacionClient habitacionClient;

    public ReservaMapper(HuespedClient huespedClient, HabitacionClient habitacionClient) {
        this.huespedClient = huespedClient;
        this.habitacionClient = habitacionClient;
    }

    @Override
    public ReservaResponse entityToResponse(Reserva entity) {
        if (entity == null) {
            return null;
        }
        HuespedResponse huesped= huespedClient.getHuespedById(entity.getIdHuesped());
      
        // Huespedes
        Set<Integer> habitaciones = entity.getHabitaciones()
                .stream()
                .map(Habitacion::getNumero)
                .collect(Collectors.toSet());
        
        entity.getHabitaciones().forEach(habitacion -> {
			habitaciones.add(habitacion.getNumero());
		});
        	
        
        //The constructor ReservaResponse(Long, Date, Date, Integer, Double, String, Set<String>, String)
        
        return new ReservaResponse(
                entity.getIdReservacion(),
                entity.getFecha_entrada(),
                entity.getFecha_salida(),
                entity.getNoches(),
                entity.getTotal(),     // Double
                entity.getEstado(),
                huesped.nombre(),
                habitaciones
               
        );
    }

    @Override
    public Reserva requestToEntity(ReservaRequest request) {
        if (request == null) {
            return null;
        }

        Reserva reserva = new Reserva();
        reserva.setFecha_entrada(request.fecha_entrada());
        reserva.setFecha_salida(request.fecha_salida());
        reserva.setNoches(request.noches());
        reserva.setIdHuesped(request.idHuesped()); 
        reserva.setTotal(request.total());
        reserva.setEstado(request.estado());

        // Habitaciones
        Set<Habitacion> habitaciones = new HashSet<>();
        request.idHabitaciones().forEach(id -> {
            Habitacion habitacion = this.habitacionResponseToHabitacion(habitacionClient.getHabitacionXById(id));
            habitaciones.add(habitacion);
        });
        
        reserva.setHabitaciones(habitaciones);
        return reserva;
    }


    private Habitacion habitacionResponseToHabitacion(HabitacionResponse response) {
        if (response == null) {
            return null;
        }

        Habitacion habitacion = new Habitacion();
        habitacion.setId(response.id());
        habitacion.setNumero(response.numero().intValue());
        return habitacion;
    }
}
