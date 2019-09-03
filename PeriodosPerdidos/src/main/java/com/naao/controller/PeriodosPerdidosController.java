/**
 * 
 */
package com.naao.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naao.helpers.PeriodoMasFaltanteCompleter;
import com.naao.model.Periodo;
import com.naao.model.PeriodoMasFaltantes;

/**
 * @author nestor
 *
 */
@RestController
public class PeriodosPerdidosController {

	private static final Logger log = LoggerFactory.getLogger(PeriodosPerdidosController.class);

	@Autowired
	private Environment env;

	@GetMapping(value = "/")
	public PeriodoMasFaltantes getPeriodo() {
		log.info("Get root (getPeriodo)");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Periodo periodo = restTemplate.getForObject(env.getProperty("app.external-url"), Periodo.class);
		PeriodoMasFaltantes periodoMasFaltante = new PeriodoMasFaltantes(periodo);
		PeriodoMasFaltanteCompleter.execute(periodoMasFaltante);
		log.info("El retorno es " + periodoMasFaltante);
		return periodoMasFaltante;
	}
}
