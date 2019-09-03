package com.naao.helpers;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.naao.model.PeriodoMasFaltantes;

public class PeriodoMasFaltanteCompleter {

	private static final Logger log = LoggerFactory.getLogger(PeriodoMasFaltanteCompleter.class);

	public static void execute(PeriodoMasFaltantes periodoMasFaltante) {
		if (periodoMasFaltante == null || periodoMasFaltante.getFechaCreacion() == null
				|| periodoMasFaltante.getFechaFin() == null) {
			log.warn("PeriodoMasFaltanteCompleter.execute no ejecutado debido a argumentos faltantes");
			return;
		}
		LocalDate creacion = periodoMasFaltante.getFechaCreacion();
		LocalDate fin = periodoMasFaltante.getFechaFin();
		if (fin.compareTo(creacion) < 0) { // swap
			LocalDate temp = creacion;
			creacion = fin;
			fin = temp;
		}
		log.info("PeriodoMasFaltanteCompleter.execute ejecutandose " + creacion + " -> " + fin);
		List<LocalDate> fechas = getFechasPeriodo(creacion, fin);
		periodoMasFaltante.setFechasFaltante(fechas);
		deleteFromArrayWhenExistsIn(periodoMasFaltante.getFechasFaltantes(), periodoMasFaltante.getFechas());
	}

	public static List<LocalDate> getFechasPeriodo(LocalDate desde, LocalDate hasta) {
		List<LocalDate> fechas = null;
		if (desde == null || hasta == null)
			return null;
		desde = LocalDate.of(desde.getYear(), desde.getMonth(), 1);
		hasta = LocalDate.of(hasta.getYear(), hasta.getMonth(), 1);
		LocalDate cadaFecha = desde;
		while (cadaFecha.compareTo(hasta) < 0) {
			if (fechas == null)
				fechas = new ArrayList<LocalDate>();
			fechas.add(cadaFecha);
			cadaFecha = cadaFecha.plus(Period.ofMonths(1));
			cadaFecha = LocalDate.of(cadaFecha.getYear(), cadaFecha.getMonth(), 1);
		}
		return fechas;
	}

	public static void deleteFromArrayWhenExistsIn(List<LocalDate> from, List<LocalDate> whenExistsIn) {
		Iterator<LocalDate> i = from.iterator();
		while (i.hasNext()) {
			LocalDate o = i.next();
			if (whenExistsIn.contains(o))
				i.remove();
		}
	}

}
