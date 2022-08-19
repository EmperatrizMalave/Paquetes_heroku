package com.paquetes.app.service;

import java.util.List;

import com.paquetes.app.entity.Servicio;

public interface IPaqueteServicio {


	public List<Servicio> findAll();

	public Servicio save(Servicio servicio); 

	public Servicio deleteById(Long id);
	
	public Servicio findById(Long id);
}
