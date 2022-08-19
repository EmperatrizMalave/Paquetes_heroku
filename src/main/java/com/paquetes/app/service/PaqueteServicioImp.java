package com.paquetes.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paquetes.app.entity.Servicio;
import com.paquetes.app.repository.IServicioRepository;

@Service
public class PaqueteServicioImp implements IPaqueteServicio{

	@Autowired
	IServicioRepository servicioRepository;
	
	@Override
	public List<Servicio> findAll() {
		return (List<Servicio>) servicioRepository.findAll();
	}

	@Override
	public Servicio save(Servicio servicio) {
		return servicioRepository.save(servicio);
	}

	@Override
	public Servicio deleteById(Long id) {
		Servicio servicio= findById(id);
		servicioRepository.deleteById(id);
		return servicio;
	}

	@Override
	public Servicio findById(Long id) {
		return servicioRepository.findById(id).orElse(null);
	}
}
