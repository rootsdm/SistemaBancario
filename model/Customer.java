package model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "customer")
@DynamicUpdate
@DynamicInsert
public final class Customer {
	// atributos
	@Id
	@GeneratedValue(generator = "sequence_customer", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_customer", sequenceName = "sequence_customer", initialValue = 1, allocationSize = 1)
	@Column(name = "idCustomer", nullable = false)
	private int idCustomer; // PK

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = true)
	private int age;

	@Column(name = "address", nullable = true)
	private String address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accounts;

	// construtor vazio
	public Customer() {

	}

	public Customer(int idCostumer, String cpf, String name, int age, String address, List<Account> accounts) {
		this.idCustomer = idCostumer;
		this.cpf = cpf;
		this.name = name;
		this.age = age;
		this.address = address;
		this.accounts = accounts;
	}

	// metodos da classe

	// geters e seters

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, address, age, cpf, idCustomer, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(address, other.address) && age == other.age
				&& Objects.equals(cpf, other.cpf) && idCustomer == other.idCustomer && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", cpf=" + cpf + ", name=" + name + ", age=" + age + ", address="
				+ address + ", accounts=" + accounts + "]";
	}

}
