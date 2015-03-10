package de.koehler.money;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.koehler.money.entity.Account;
import de.koehler.money.entity.Currency;
import de.koehler.money.entity.Transaction;
import de.koehler.money.entity.queries.AccountQueries;

/**
 * 
 * @author Matthias Köhler
 */
public class App {
	
	
	public static void main(String[] args) {
		
		// 1. create connection...
		EntityManager entityManager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
		entityManager.getTransaction().begin();

		// 2. setup testdata...
		Currency currency = new Currency();
		currency.setName("Euronen");
		currency.setIsoCode("EUR");
		
		Account account = new Account();
		account.setName("Deutsche Kreditbank Berlin");
		account.setCurrency(currency);
		
		Transaction transaction1 = new Transaction();		
		transaction1.setDescription("erste Überweisung");
		transaction1.setCurrency(currency);
		transaction1.setAmount(new BigDecimal(1));
		transaction1.setDate(new Date(System.currentTimeMillis()));		
		account.getTransactions().add(transaction1);
		
		// 3. persist testdata...
		entityManager.persist(currency);
		entityManager.persist(transaction1);
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		
		// 4. query testdata...
		TypedQuery<Account> query = entityManager.createNamedQuery(AccountQueries.FIND_ALL, Account.class);
		List<Account> resultList = query.getResultList();
		entityManager.close();
		
		// 5. print result...
		System.out.println("Number of accounts: " + resultList.size());
		for (Account next : resultList) {
			System.out.println(next);
		}
	}
}
