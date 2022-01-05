package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.person.StateProvince;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "SalesTerritory.findAll", query = "SELECT s FROM SalesTerritory s")
public class SalesTerritory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Unique identifier of the territory.
	 */
	@Id
	@SequenceGenerator(name = "SALESTERRITORY_TERRITORYID_GENERATOR", allocationSize = 1, sequenceName = "SALESTERRITORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESTERRITORY_TERRITORYID_GENERATOR")
	@Getter
	@Setter
	private Integer territoryID;
	
	
	/**
	 * Sales territory description.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Geographic area to which the sales territory belong.
	 */
	@Getter
	@Setter
	private String group;
	
	
	/**
	 * Sales in the territory year to date.
	 */
	@Getter
	@Setter
	private BigDecimal salesYearToDate;
	
	
	/**
	 * Sales in the territory the previous year.
	 */
	@Getter
	@Setter
	private BigDecimal salesLastYear;
	
	
	/**
	 * Business costs for the territory year to-date.
	 */
	@Getter
	@Setter
	private BigDecimal costYearToDate;
	
	
	/**
	 * Business costs for the territory the previous year.
	 */
	@Getter
	@Setter
	private BigDecimal costLastYear;
	
	
	/**
	 * Date the sales territory was last edited.
	 */
	@Getter
	@Setter
	private LocalDateTime moddifiedDate;
	
	
	/**
	 * List of customers that are located in the territory.
	 */
	@OneToMany(mappedBy = "salesterritory")
	@Getter
	@Setter
	private List<Customer> customers;
	
	
	/**
	 * List of sales order headers that are located in the territory.
	 */
	@OneToMany(mappedBy = "salesterritory")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	/**
	 * List of state-provinces that are located in the territory
	 */
	@OneToMany(mappedBy = "salesterritory")
	@Getter
	@Setter
	private List<StateProvince> stateProvinces;
	
	
	/**
	 * List of sales persons that are located in the territory
	 */
	@OneToMany(mappedBy = "salesterritory")
	@Getter
	@Setter
	private List<SalesPerson> salesPersons;
	
	
	
	public SalesTerritory() {
		setCustomers(new ArrayList<Customer>());
		setSalesOrderHeaders(new ArrayList<SalesOrderHeader>());
		setStateProvinces(new ArrayList<StateProvince>());
		
		setModdifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a customer, created prior to calling this function, to a customer list. It then returns the added customer.
	 * @param customer - The customer to be added.
	 * @return The customer added.
	 */
	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setSalesterritory(this);
		
		return customer;
	}
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order header list. It then returns the sales order header added.
	 * @param salesOrderHeader - The Sales order header to be added.
	 * @return The Sales order header added.
	 */
	public SalesOrderHeader addSalesorderheader(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setSalesTerritory(this);
		
		return salesOrderHeader;
	}
	
	
	/**
	 * Adds a state-province, created prior to calling this function, to a state-province list. It then return the added state-province.
	 * @param stateProvince - THe state-province to be added.
	 * @return The state-province added.
	 */
	public StateProvince addStateProvince(StateProvince stateProvince) {
		getStateProvinces().add(stateProvince);	
		stateProvince.setSalesTerritory(this);
		
		return stateProvince;
	}
	
	
	/**
	 * 
	 * @param salesPerson
	 * @return
	 */
	public SalesPerson addSalesPerson(SalesPerson salesPerson) {
		getSalesPersons().add(salesPerson);
		salesPerson.setSalesTerritory(this);
		
		return salesPerson;
	}
}
