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

import com.google.gson.annotations.Expose;

import de.koehler.money.entity.queries.AccountQueries;

/**
 * 
 * @author Matthias Köhler
 */
//@formatter:off
@NamedQueries({ 
	@NamedQuery(name = AccountQueries.FIND_ALL, query = "SELECT a FROM Account a"),
	@NamedQuery(name = AccountQueries.FIND_BY_NAME, query = "SELECT a FROM Account a WHERE a.name = :name"),
	@NamedQuery(name = AccountQueries.FIND_BY_ID, query = "SELECT a FROM Account a WHERE a.id = :id")
})
//@formatter:on
@Entity
@Table
public @Data class Account implements AccountQueries {	
	
	@Id
	@GeneratedValue
	private Long id;

	@Expose
	@Column(name = "name")
	private String name;

	@ManyToOne
	private Currency currency;

	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions = new ArrayList<>();

	@Override
	public String toString() {
		return "Account [name=" + name + ", currency=" + currency + "]";
	}

}
