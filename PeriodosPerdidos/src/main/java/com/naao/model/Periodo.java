package com.naao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Periodo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Periodo {
	private Long id = null;
	private LocalDate fechaCreacion = null;
	private LocalDate fechaFin = null;
	private List<LocalDate> fechas = null;

	public Periodo() {
		super();
	}

	public Periodo(Long id, LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> fechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechaFin = fechaFin;
		this.fechas = fechas;
	}

	public Periodo(Periodo periodo) {
		this(periodo.id, periodo.fechaCreacion, periodo.fechaFin, periodo.fechas);
	}

	public Periodo id(Long id) {
		this.id = id;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Periodo fechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Periodo fechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
		return this;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Periodo fechas(List<LocalDate> fechas) {
		this.fechas = fechas;
		return this;
	}

	public Periodo addFechasItem(LocalDate fechasItem) {
		getFechas().add(fechasItem);
		return this;
	}

	public List<LocalDate> getFechas() {
		if (this.fechas == null) {
			this.fechas = new ArrayList<>();
		}
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Periodo periodo = (Periodo) o;
		return Objects.equals(this.id, periodo.id) && Objects.equals(this.fechaCreacion, periodo.fechaCreacion)
				&& Objects.equals(this.fechaFin, periodo.fechaFin) && Objects.equals(this.fechas, periodo.fechas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fechaCreacion, fechaFin, fechas);
	}

	@Override
	public String toString() {
		return "Periodo [id=" + id + ", fechaCreacion=" + fechaCreacion + ", fechaFin=" + fechaFin + ", fechas="
				+ fechas + "]";
	}

}
