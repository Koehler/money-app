package de.koehler.money.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table
public @Data class Currency {

	@Id
    @GeneratedValue
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "isoCode")
	private String isoCode;

	@Column(name = "active")
	private boolean active;
		
}
