/**
 * 
 */
package com.naao.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naao.model.Periodo;

/**
 * @author nestor
 *
 */
@RestController
public class PeriodosPerdidosController {

	private static final Logger log = LoggerFactory.getLogger(PeriodosPerdidosController.class);

	@GetMapping(value = "/")
	public Periodo getPeriodo() {
		log.info("Get root (getPeriodo)");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Periodo periodo = restTemplate.getForObject("http://localhost:8080/periodos/api", Periodo.class);

		return periodo;
	}
}
