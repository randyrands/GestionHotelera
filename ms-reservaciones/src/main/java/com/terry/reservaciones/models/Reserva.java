package com.terry.reservaciones.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name= "RESERVACIONES")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="RESERVACIONES_SEQ")
	@SequenceGenerator(name ="RESERVACIONES_SEQ", sequenceName = "RESERVACIONES_SEQ", allocationSize =1)
	
	@Column(name = "ID_RESERVA")
	private Long idReservacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_ENTRADA")
	private Date fecha_entrada;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_SALIDA")
	private Date fecha_salida;
	
	@Column(name = "NOCHES", nullable =false)
	private Integer noches;
	
	@Column(name = "TOTAL", nullable =false)
	private BigDecimal total;
	
	
	@Column(name = "ESTADO", nullable =false)
	private String estado;
	
	
	@Column(name= "ID_HUESPED",nullable =false)
	private Long idHuesped;
	
	@ElementCollection
	@CollectionTable(name ="RESERVA_HABITACION",
	joinColumns = @JoinColumn(name="ID_RESERVA"))
	private Set<Habitacion> habitaciones;



	public Long getIdReservacion() {
		return idReservacion;
	}

	public void setIdReservacion(Long idReservacion) {
		this.idReservacion = idReservacion;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Integer getNoches() {
		return noches;
	}

	public void setNoches(Integer noches) {
		this.noches = noches;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	

	public Long getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Long idHuesped) {
		this.idHuesped = idHuesped;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}


	
	
			
}
