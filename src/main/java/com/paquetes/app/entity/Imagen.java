package com.paquetes.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="imagenes")
public class Imagen implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 2000, nullable = false)
	private String url;//Otros campos

	private String title;

	@ManyToMany(mappedBy = "images")
	@JsonIgnore
    private List<Paquete> imagenPaquetes;
	
}
