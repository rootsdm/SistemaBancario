package model;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "account")
@DynamicUpdate
@DynamicInsert
public final class Account {
	// atributos
	@Id
	@GeneratedValue(generator = "sequence_account", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_account", sequenceName = "sequence_account", initialValue = 1, allocationSize = 1)
	@Column(name = "idAccount", nullable = false)
	private int idAccount; // PK

	@Column(name = "agency", nullable = false)
	private int agency;

	@Column(name = "numberAccount", nullable = false)
	private int numberAccount;

	@Column(name = "balance", nullable = true)
	private double balance;

	@Column(name = "dtCreate", nullable = false)
	private Calendar dtCreate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idCustomer", nullable = false)
	private Customer customer;

	public double saca(double value) {
		balance -= value;
		return balance;
	}

	public double deposit(double value) {
		balance += value;
		return balance;
	}

	public double transfer(Account sourceAccount, Account destinationAccount, double value) {
		if (sourceAccount.getBalance() >= value) {
			sourceAccount.balance -= value;
			destinationAccount.balance += value;

		}
		return balance;
	}

	public double loan(Account destinationAccount, double value) {
		balance += value;
		return balance;

	}

	public Account() {

	}

	public Account(int idAccount, int agency, int numberAccount, double balance, Calendar dtCreate, Customer customer) {
		this.idAccount = idAccount;
		this.agency = agency;
		this.numberAccount = numberAccount;
		this.balance = balance;
		this.dtCreate = dtCreate;
		this.customer = customer;

	}

	public Calendar getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(Calendar dtCreate) {
		this.dtCreate = dtCreate;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agency, balance, customer, dtCreate, idAccount, numberAccount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return agency == other.agency && Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(customer, other.customer) && Objects.equals(dtCreate, other.dtCreate)
				&& idAccount == other.idAccount && numberAccount == other.numberAccount;
	}

}
