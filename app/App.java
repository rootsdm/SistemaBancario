package app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DAO.DAO;
import model.Account;
import model.Customer;

import service.ServiceAccount;
import service.ServiceCustomer;

public class App {

	public static void main(String[] args) {
		
		ServiceCustomer serviceCostumer = new ServiceCustomer();
		ServiceAccount serviceAccount = new ServiceAccount();
		Calendar date = Calendar.getInstance();
		//Customer customer2 = serviceCostumer.getCustomerAccount(1); // id customer setado manualmente.

//		// inclusão de cliente 1
//		Customer customer1 = new Customer();
//		customer1.setName("Lucas Almeida");
//		customer1.setAge(25);
//		customer1.setCpf("818.761.520-60");
//		customer1.setAddress("Av. Agamenon Magalhaes");
//		serviceCostumer.checkCpf(customer1);
//
//		// inclusão de cliente 2
//		Customer customer2 = new Customer();
//		customer2.setName("Maria do Carmo");
//		customer2.setAge(53);
//		customer2.setCpf("935.933.400-62");
//		customer2.setAddress("Rua via Lactea");
//		serviceCostumer.checkCpf(customer2);
//		
//		
//		// inclusão de conta 1
//		Account account1 = new Account();
//		account1.setAgency(456);
//		account1.setNumberAccount(888);
//		account1.setBalance(0);
//		account1.setDtCreate(date);
//		account1.setCustomer(customer1);
//		serviceAccount.checkAccount(account1);
//
//		// inclusão de conta 2
//		Account account2 = new Account();
//		account2.setAgency(852);
//		account2.setNumberAccount(654);
//		account2.setBalance(0);
//		account2.setDtCreate(date);
//		account2.setCustomer(customer2);
//		serviceAccount.checkAccount(account2);

		// deposito conta 1
		//serviceAccount.checkDeposit(21, 5000); 
		
		
		// deposito conta 2
		//serviceAccount.checkDeposit(22, 10000);
		
		// saque conta 1
		//serviceAccount.checkWithdraw(21, 1000);
		
		// saque conta 2
		//serviceAccount.checkWithdraw(22, 2000);
		
		// transfer
		//serviceAccount.checkTransf(22, 21, 352);
		
		// emprestimo conta 1
		serviceAccount.checkLoan(33, 5000);
		
		
	}
}
