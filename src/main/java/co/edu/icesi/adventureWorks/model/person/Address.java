package co.edu.icesi.adventureWorks.model.person;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.sales.SalesOrderHeader;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key for address rows.
	 */
	@Id
	@SequenceGenerator(name = "ADDRESS_ADDRESSID_GENERATOR", allocationSize = 1, sequenceName = "ADDRESS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ADDRESSID_GENERATOR")
	@Getter
	@Setter
	private Integer addressID;
	
	
	/**
	 * First street-address line.
	 */
	@Getter
	@Setter
	private String addressLine1;
	
	
	/**
	 * Second street address line.
	 */
	@Getter
	@Setter
	private String addressLine2;
	
	
	/**
	 * Name of the city.
	 */
	@Getter
	@Setter
	private String city;
	
	
	/**
	 * Postal code for the street address.
	 */
	@Getter
	@Setter
	private String postalCode;
	
	
	/**
	 * Date the address was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * Information about the state or province.
	 */
	@Getter
	@Setter
	private StateProvince stateprovince;
	
	
	/**
	 * List of sales order headers that use this address.
	 */
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	
	public Address() {
		setSalesOrderHeaders(new ArrayList<SalesOrderHeader>());
		setModifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order headers list. It then returns the added sales order header.
	 * In the sales order header the bill address is then changed to the current address.
	 * @param salesOrderHeader - The sales order header to be added.
	 * @return The sales order header added. 
	 */
	public SalesOrderHeader addSalesorderheaderBill(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setBillToAddress(this);
		
		return salesOrderHeader;
	}
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order headers list. It then returns the added sales order header.
	 * In the sales order header the ship address is then changed to the current address.
	 * @param salesOrderHeader - The sales order header to be added.
	 * @return The sales order header added. 
	 */
	public SalesOrderHeader addSalesorderheaderShip(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setShipToAddress(this);
		
		return salesOrderHeader;
	}
}
