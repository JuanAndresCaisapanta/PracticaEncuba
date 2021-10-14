package com.PracticaSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PracticaSpringBoot.models.PracspringbootPersona;
import com.PracticaSpringBoot.repository.PracspringbootPersonaRepository;
@Service
public class PracspringbootPersonaService {
	@Autowired
	private PracspringbootPersonaRepository pracspringbootPersonaRepository; 
	
	public List<PracspringbootPersona> obtenerTodosPersona(){
		return (List<PracspringbootPersona>) pracspringbootPersonaRepository.findAll();
	}
	
	public PracspringbootPersona guardarPersona( PracspringbootPersona objGesvacPersona ) {
		return pracspringbootPersonaRepository.save(objGesvacPersona);
	}
	
	public void elminarPersona(PracspringbootPersona objGesvacPersona) {
		pracspringbootPersonaRepository.delete(objGesvacPersona);
	}

}
