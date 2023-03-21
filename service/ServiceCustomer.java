package service;

import java.util.List;

import DAO.DAO;
import model.Customer;

public class ServiceCustomer {
	// ok
	public boolean checkCpf(Customer customer) {

		List<Customer> listCustomer = DAO.listCustomer();

		for (Customer customer2 : listCustomer) {
			if (customer2.getCpf().equals(customer.getCpf()) 
					|| (customer.getName().isEmpty())) {
				System.out.println("Erro: Cliente já Existe? ou Existe Campos em Branco!");

				return true;

			}

		}
		System.out.println("Cliente foi Incluído!");
		DAO.insertCustomer(customer);
		return false;

	}



	public Customer getCustomerAccount(int id) {
		List<Customer> listCustomerDAO = DAO.listCustomer();

		for (Customer customer2 : listCustomerDAO) {
			if (customer2.getIdCustomer() == id) {
				System.out.println("Cliente já Existe!");

				return customer2;

			} else {
				System.out.println("Cliente não existe!");
			}

		}

		return null;
	}
}
