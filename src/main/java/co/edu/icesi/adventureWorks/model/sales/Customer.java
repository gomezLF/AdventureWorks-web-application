package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for Customer rows.
	 */
	@Id
	@SequenceGenerator(name = "CUSTOMER_CUSTOMERID_GENERATOR", allocationSize = 1, sequenceName = "CUSTOMER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_CUSTOMERID_GENERATOR")
	@Getter
	@Setter
	private Integer customerID;
	
	
	/**
	 * Unique number that identifies the customer.
	 */
	@Getter
	@Setter
	private Integer accountNumber;
	
	
	/**
	 * Customer type. It can be an individual or a store. 
	 */
	@Getter
	@Setter
	private CustomerType customerType;
	
	
	/**
	 * Date the customer was last edited.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * Territory in which the customer is located.
	 */
	@ManyToOne
	@JoinColumn(name = "territoryid")
	@Getter
	@Setter
	private SalesTerritory salesterritory;
	
	
	/**
	 * List of all sales order headers in which the customer appears.
	 */
	@OneToMany(mappedBy = "customer")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	/**
	 * Stores in which the current customer has purchased.
	 */
	@ManyToMany(mappedBy = "customers")
	@Getter
	@Setter
	private List<Store> stores;
	
	
	
	public Customer() {
		setSalesOrderHeaders(new ArrayList<SalesOrderHeader>());
		setModifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order header list. It then returns the sales order header added.
	 * @param salesOrderHeader - The Sales order header to be added.
	 * @return The Sales order header added.
	 */
	public SalesOrderHeader addSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setCustomer(this);
		
		return salesOrderHeader;
	}
}
