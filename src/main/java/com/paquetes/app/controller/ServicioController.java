package com.paquetes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paquetes.app.entity.Servicio;
import com.paquetes.app.service.IPaqueteServicio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/api") //localhost:port/api
public class ServicioController {

	@Autowired
	IPaqueteServicio paqueteServicio;
	
	@GetMapping("/servicios") //localhost:puerto/api/customers
	public List<Servicio> servicio(){
		return (List<Servicio>) paqueteServicio.findAll();		
	}
	
	@GetMapping("/servicios/{id}")
	public Servicio ById(@PathVariable Long id) {		
		return paqueteServicio.findById(id);
	}
	
	@PostMapping("/servicios")
	public Servicio newPaquetes(@RequestBody Servicio servicio) {
		servicio.setId(null);
		return paqueteServicio.save(servicio);
	}
	
	@PutMapping("/servicios")
	public Servicio replacePaquetes(@RequestBody Servicio servicio) {
		//Filtros para asegurar que esté un ID y exista
		return paqueteServicio.save(servicio);
	}
}
