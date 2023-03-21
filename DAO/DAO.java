package DAO;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Account;
import model.Customer;

public class DAO {

	public static Customer insertCustomer(Customer customer) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();

		try {
			conecta.getTransaction().begin();
			conecta.persist(customer);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();

		}

		return customer;

	}

	public static void updateNameCustomer(Customer customer) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {
			conecta.getTransaction().begin();
			customer = conecta.find(Customer.class, 1);
			if (Objects.nonNull(customer)) {
				customer.setName("Vinicius da Silvia");
				System.out.println(customer);

			} else {
				System.out.println("Cliente não localizado, não pude atualizar");
			}
			conecta.merge(customer);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();

		}
	}

	// pesquisa de cliente por id - ok
	public static Customer findByIdCustomer(int id) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		Customer customer = null;
		try {
			customer = conecta.find(Customer.class, id);
			System.out.println(customer);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			conecta.close();
		}
		return customer;
	}

	@SuppressWarnings("unchecked")
	public static List<Customer> listCustomer() {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {

			Query query = conecta.createQuery("From Customer");

			return query.getResultList();

		} catch (Exception e) {
			System.err.println(e);
			return null;

		} finally {
			conecta.close();
		}

	}

	public static void deleteCustomer(int id) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {
			conecta.getTransaction().begin();
			Customer customer = conecta.find(Customer.class, id);
			System.out.println("Excluindo o cliente: " + customer.getName());
			conecta.remove(customer);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();
		}
	}

	public static Account insertAccount(Account account) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();

		try {
			conecta.getTransaction().begin();
			conecta.persist(account);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();

		}
		return account;
	}

	
	public static Account updateAccount(Account account) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		
		try {
			conecta.getTransaction().begin();
			conecta.merge(account);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();

		}
		return account;
	}
	
	
	public static void updateNumberAccount(Account account) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {
			conecta.getTransaction().begin();
			account = conecta.find(Account.class, 1);
			if (Objects.nonNull(account)) {
				account.setNumberAccount(1324654);
				System.out.println(account);

			} else {
				System.out.println("Conta não localizada, não pude atualizar");
			}
			conecta.merge(account);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();

		}
	}
	
	public static Account findByIdAccount(int id) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		Account account = null;
		try {
			account = conecta.find(Account.class, id);
			System.out.println(account);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			conecta.close();
		}
		return account;
	}

	
	
	@SuppressWarnings("unchecked")
	public static List<Account> listAccount() {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {

			Query query = conecta.createQuery("From Account");

			return query.getResultList();

		} catch (Exception e) {
			System.err.println(e);
			return null;

		} finally {
			conecta.close();
		}

	}

	public static void deleteAccount(int id) {
		EntityManager conecta = jpaUtil.JPAUtil.getEntityManager();
		try {
			conecta.getTransaction().begin();
			Account account = conecta.find(Account.class, id);
			System.out.println("Excluindo a Conta: " + account.getNumberAccount());
			conecta.remove(account);
			conecta.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			conecta.getTransaction().rollback();
		} finally {
			conecta.close();
		}
	}

}
