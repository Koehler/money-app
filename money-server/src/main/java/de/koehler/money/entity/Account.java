package de.koehler.money.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import de.koehler.money.entity.queries.AccountQueries;

/**
 * 
 * @author Matthias Köhler
 */
//@formatter:off
@NamedQueries({ 
	@NamedQuery(name = AccountQueries.FIND_ALL, query = "SELECT account FROM Account account"),
	@NamedQuery(name = AccountQueries.FIND_BY_NAME, query = "SELECT account FROM Account account WHERE account.name = :name"),
	@NamedQuery(name = AccountQueries.FIND_BY_ID, query = "SELECT account FROM Account account WHERE account.id = :id")
})
//@formatter:on
@Entity
@Table
public @Data class Account implements AccountQueries {	
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private Currency currency;

	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions = new ArrayList<>();

}
