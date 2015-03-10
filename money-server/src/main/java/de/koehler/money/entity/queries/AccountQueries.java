package de.koehler.money.entity.queries;



/**
 * Interface to collect all NamedQueries used for Account.
 * 
 * @author Matthias Köhler
 */
public interface AccountQueries {
	
	/**
	 * NamedQuery to find all {@code Account}s.
	 */
	public static final String FIND_ALL = "Account.findAllAccounts";
	
	/**
	 * NamedQuery to find multiple {@code Account}s by name.
	 */
	public static final String FIND_BY_NAME = "Account.findAccountsByName";
	
	/**
	 * NamedQuery to find a single {@code Account} by id.
	 */
	public static final String FIND_BY_ID = "Account.findAccountById";
	
}
