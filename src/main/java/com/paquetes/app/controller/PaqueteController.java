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

import com.paquetes.app.entity.Paquete;
import com.paquetes.app.service.IPaqueteService;

@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping(path="/api") //localhost:port/api
	public class PaqueteController {
		
	@Autowired
		IPaqueteService paqueteService;
		
		@GetMapping("/paquetes") //localhost:puerto/api/customers
		public List<Paquete> paquetes(){
			return (List<Paquete>) paqueteService.findAll();		
		}
		
		@GetMapping("/paquetes/{id}")
		public Paquete paquetesById(@PathVariable Long id) {		
			return  paqueteService.findById(id);
		}
		
		@PostMapping("/paquetes")
		public Paquete newPaquetes(@RequestBody Paquete paquete) {
			paquete.setId(null);
			return paqueteService.save(paquete);
		}
		
		@PutMapping("/paquetes")
		public Paquete replacePaquetes(@RequestBody Paquete paquete) {
			//Filtros para asegurar que esté un ID y exista
			return paqueteService.save(paquete);
		}
}
