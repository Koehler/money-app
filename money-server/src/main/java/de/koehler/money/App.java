package de.koehler.money;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.koehler.money.entity.Account;
import de.koehler.money.entity.Currency;
import de.koehler.money.entity.Transaction;

/**
 * 
 *@author matthias
 */
public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

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
		
		session.save(currency);
		session.save(transaction1);
		session.save(account);

		session.getTransaction().commit();

		Query q = session.createQuery("From Account ");

		List<Account> resultList = q.list();
		System.out.println("num of employess:" + resultList.size());
		for (Account next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
}
