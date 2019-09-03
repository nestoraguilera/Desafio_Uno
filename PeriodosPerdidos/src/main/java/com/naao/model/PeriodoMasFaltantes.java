package com.naao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeriodoMasFaltantes extends Periodo {
	private List<LocalDate> fechasFaltantes = null;

	public PeriodoMasFaltantes() {
		super();
	}

	public PeriodoMasFaltantes(Long id, LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> fechas,
			List<LocalDate> fechasFaltantes) {
		super(id, fechaCreacion, fechaFin, fechas);
		this.fechasFaltantes = fechasFaltantes;
	}

	public PeriodoMasFaltantes(Periodo periodo) {
		super(periodo);
		this.fechasFaltantes = null;
	}

	public List<LocalDate> getFechasFaltantes() {
		if (this.fechasFaltantes == null) {
			this.fechasFaltantes = new ArrayList<>();
		}
		return fechasFaltantes;
	}

	public void setFechasFaltante(List<LocalDate> fechasFaltante) {
		this.fechasFaltantes = fechasFaltante;
	}

	public PeriodoMasFaltantes addFechasFaltantesItem(LocalDate fecha) {
		getFechasFaltantes().add(fecha);
		return this;
	}

	public PeriodoMasFaltantes fechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
		return this;
	}

	@Override
	public String toString() {
		return "PeriodoMasFaltantes [" + super.toString() + ", fechasFaltantes=" + fechasFaltantes + "]";
	}

}
