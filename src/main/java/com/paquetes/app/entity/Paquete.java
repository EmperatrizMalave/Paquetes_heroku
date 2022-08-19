package com.paquetes.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import javax.persistence.JoinColumn;

@Entity
@Data
@Table(name="paquetes")
public class Paquete implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String name;

	private double costo;

	@Column(length = 3000)
	private String title;

	@OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Servicio> services;

	@ManyToMany
	@JoinTable(
		name = "paquetes_images", 
		joinColumns = @JoinColumn(name = "paquetes_id"), 
		inverseJoinColumns = @JoinColumn(name = "imagenes_id"))
	private List<Imagen> images;
}
