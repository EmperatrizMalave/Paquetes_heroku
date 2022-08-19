package com.paquetes.app.service;

import java.util.List;

import com.paquetes.app.entity.Paquete;

public interface IPaqueteService {

	/**
	 * Enlista todos los Paquetess de la base de datos
	 * @param Paquete 
	 * @return Listado de Paquetess
	 */
	public List<Paquete> findAll();
	/**
	 * Nos guarda el Paquetes en la base de datos
	 * @param Paquete Datos del Paquetes
	 * @return Devuelve el Paquetes con el Id asignado
	 */ 
	public Paquete save(Paquete paquete); 
	
	/**
	 * Elimina un Paquetes de la base de datos
	 * @param Id identificador del Paquetes a eliminar
	 */
	public Paquete deleteById(Long id);
	
	/**
	 * Encontrar un Paquetes en la base de datos
	 * @param Id identificador del Paquetes a buscar
	 * @return
	 */
	public Paquete findById(Long id);
}
