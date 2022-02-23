package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key for Store rows
	 */
	@Id
	@SequenceGenerator(name = "STORE_STOREID_GENERATOR", allocationSize = 1, sequenceName = "STORE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_STOREID_GENERATOR")
	@Getter
	@Setter
	private Integer storeID;
	
	/**
	 * Name of the store.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Demographic information about the store such as the number of employees, annual sales and store type. 
	 */
	@Getter
	@Setter
	private String demographics;
	
	
	/**
	 * Date the store was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * Customers who have purchased from the store.
	 */
	@ManyToMany(mappedBy = "stores")
	@Getter
	@Setter
	private List<Customer> customers;
	
	
	/**
	 * Adventure Works sales representative responsible for selling products to the store.
	 */
	@OneToMany(mappedBy = "store")
	@Getter
	@Setter
	private List<SalesPerson> salesPersons;
	
	
	
	public Store() {
		setCustomers(new ArrayList<Customer>());
		setSalesPersons(new ArrayList<SalesPerson>());
		setModifiedDate(LocalDate.now());
	}
	
	
	
	/**
	 * Adds a customer, created prior to calling this function, to the customer list. It then return the customer added.
	 * @param customer - The customer to be added.
	 * @return The customer added.
	 */
	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.getStores().add(this);
		
		return customer;
	}
	
	
	/**
	 * Adds a salesperson, created prior to calling this function, to the salesperson list. It then return the salesperson added.
	 * @param salesPerson - The salesperson to be added.
	 * @return The salesperson added.
	 */
	public SalesPerson addSalesPerson(SalesPerson salesPerson) {
		getSalesPersons().add(salesPerson);
		salesPerson.setStore(this);
		
		return salesPerson;
	}
}
