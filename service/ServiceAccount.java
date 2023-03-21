package service;

import java.util.List;

import DAO.DAO;
import model.Account;
import model.Customer;

public class ServiceAccount {
	public boolean checkAccount(Account account) {

		List<Account> listAccount = DAO.listAccount();

		for (Account account2 : listAccount) {
			if (account2.getNumberAccount() == (account.getNumberAccount()) || (account.getAgency() == 0)
					|| (account.getNumberAccount() == 0)) {
				System.out.println("Erro: Conta já Existe? ou Agencia/Numero da conta inválido!");

				return true;

			}

		}
		System.out.println("Cliente foi Incluído!");
		DAO.insertAccount(account);
		return false;

	}

	public void checkWithdraw(int idAccount, double value) {
		Account conta = DAO.findByIdAccount(idAccount);
		if ((conta != null) && (value <= conta.getBalance())) {
			conta.saca(value);
			DAO.updateAccount(conta);
			System.out.println("Saque Realizado");

		} else {
			System.out.println("Saldo Insuficiente: Saque não pode ser Realizado");

		}

	}

	public void checkDeposit(int idAccount, double value) {
		Account account = DAO.findByIdAccount(idAccount);
		if ((account != null)) {
			account.deposit(value);
			DAO.updateAccount(account);
			System.out.println("Deposito Realizado");

		} else {
			System.out.println("Desposito não pode ser Realizado");

		}

	}

	public void checkTransf(int idSourceAccount, int idDestinationAccount, double value) {
		Account accountSource = DAO.findByIdAccount(idSourceAccount);
		Account accountDestination = DAO.findByIdAccount(idDestinationAccount);
		if ((accountSource != null) && (accountDestination != null) && accountSource.getBalance() >= value) {

			accountDestination.transfer(accountSource, accountDestination, value);
			DAO.updateAccount(accountDestination);
			DAO.updateAccount(accountSource);
			System.out.println("Transferencia Realizada");

		} else {
			System.out.println("Transferência não pode ser Realizada");
		}

	}

	
	public void checkLoan(int idAccount, double value) {
		Account account = DAO.findByIdAccount(idAccount);
		if ((account != null)) {
			account.loan(account, value);
			DAO.updateAccount(account);
			System.out.println("Empréstimo Realizado");

		} else {
			System.out.println("ERRO: Conta não existe: Emprestimo não pode ser Realizado");

		}

	}
}
