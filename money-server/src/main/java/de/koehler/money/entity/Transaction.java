package de.koehler.money.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
public @Data class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "amount")
	private BigDecimal amount;

	@ManyToOne
	private Account account;
	
	@ManyToOne
	private Currency currency;

	@Column(name = "description")
	private String description;

}
