package com.paquetes.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="servicios")
public class Servicio implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length = 150, nullable = false)
	private String name;

	
	@JoinColumn(name = "paquete_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private Paquete paquete;
	
	@ManyToMany
	@JoinTable(
		name = "servicios_items", 
		joinColumns = @JoinColumn(name = "servicios_id"), 
		inverseJoinColumns = @JoinColumn(name = "items_id"))
	private List<Item> items;
	
}
