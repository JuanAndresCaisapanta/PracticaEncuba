package com.PracticaSpringBoot.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.PracticaSpringBoot.Utils.ModelUtil;
import com.PracticaSpringBoot.models.PracspringbootPersona;
import com.PracticaSpringBoot.services.PracspringbootPersonaService;

@RestController
@RequestMapping("/persona")
public class PracspringbootPersonaController {
	private static final Logger logger = LoggerFactory.getLogger(PracspringbootPersonaController.class);

	private PracspringbootPersonaService pracspringbootPersonaService;

	public PracspringbootPersonaController(PracspringbootPersonaService pracspringbootPersonaService) {
		super();
		this.pracspringbootPersonaService = pracspringbootPersonaService;
	}

	@GetMapping(produces = "application/json")
	public List<PracspringbootPersona> obtenerAllPersonas() {
		return pracspringbootPersonaService.obtenerTodosPersona();
	}

	@PostMapping(produces = "application/json")
	public String ingresarPersona(@RequestBody @Validated PracspringbootPersona objPracspringbootPersona)
			throws Exception {
		try {
			validacionDatosPersona(objPracspringbootPersona);

			pracspringbootPersonaService.guardarPersona(objPracspringbootPersona);
			return "100";
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Persona. " + e.getMessage());
			return e.getMessage();
		}
		/*
		 * objGesvacPersona.getGesvacPersonaEnfermedads() .forEach(enfermedad ->
		 * enfermedad.setGesvacPersona(objGesvacPersona));
		 */
	}

	@PutMapping(produces = "application/json")
	public String actualizarPersona(@RequestBody @Validated PracspringbootPersona objPracspringbootPersona)
			throws Exception {
		try {
			validacionDatosPersona(objPracspringbootPersona);

			pracspringbootPersonaService.guardarPersona(objPracspringbootPersona);

			return "100";
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio actualizar Persona. " + e.getMessage());
			return e.getMessage();
		}

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean eliminarPersona(@RequestBody @Validated PracspringbootPersona objPracspringbootPersona)
			throws Exception {
		try {
			pracspringbootPersonaService.elminarPersona(objPracspringbootPersona);
			return true;
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Persona. " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	private void validacionDatosPersona(PracspringbootPersona objPracspringbootPersona) throws Exception {
		ModelUtil.verificarCedulaEcuador(objPracspringbootPersona.getCedula());
		ModelUtil.esEmailCorrecto(objPracspringbootPersona.getCorreoElectronico());
		if (!ModelUtil.esSoloLetras(objPracspringbootPersona.getApellidos()))
			throw new Exception("101");
		if (!ModelUtil.esSoloLetras(objPracspringbootPersona.getNombres()))
			throw new Exception("102");
		if (ModelUtil.verificarFechaNull(objPracspringbootPersona.getFechaNacimiento()))
			throw new Exception("103");
		if (ModelUtil.verificarStringVacio(objPracspringbootPersona.getCedula()))
			throw new Exception("104");
		if (!ModelUtil.esSoloLetras(objPracspringbootPersona.getCanton()))
			throw new Exception("105");
		if (!ModelUtil.esSoloNumeros(objPracspringbootPersona.getTelefono()))
			throw new Exception("106");
		if (ModelUtil.verificarStringVacio(objPracspringbootPersona.getCorreoElectronico()))
			throw new Exception("107");
		if (ModelUtil.verificarStringVacio(objPracspringbootPersona.getDirecion()))
			throw new Exception("108");
		if (!ModelUtil.esSoloLetras(objPracspringbootPersona.getProvincia()))
			throw new Exception("109");

	}

}
