package co.edu.icesi.adventureWorks.model.purchasing;

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

import co.edu.icesi.adventureWorks.model.sales.SalesOrderHeader;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "ShipMethod.findAll", query =  "SELECT s FROM ShipMethod s")
public class ShipMethod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for ShipMethod rows.
	 */
	@Id
	@SequenceGenerator(name = "SHIPMETHOD_SHIPMETHODID_GENERATOR", allocationSize = 1, sequenceName = "SHIPMETHOD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPMETHOD_SHIPMETHODID_GENERATOR")
	@Getter
	@Setter
	private Integer shipMethodID;
	
	
	/**
	 * Shipping company name.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Minimum shipping charge.
	 */
	@Getter
	@Setter
	private BigDecimal shipBase;
	
	
	/**
	 * Shipping charge per pound.
	 */
	@Getter
	@Setter
	private BigDecimal shipRate;
	
	
	/**
	 * Date the ship method was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * List of all the sales order headers that use this ship method.
	 */
	@OneToMany(mappedBy = "shipmethod")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	
	public ShipMethod() {
		setSalesOrderHeaders(new ArrayList<SalesOrderHeader>());
		setModifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order headers list. It then returns the added sales order header.
	 * @param salesOrderHeader - The sales order header to be added.
	 * @return The sales order header added. 
	 */
	public SalesOrderHeader addSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setShipMethod(this);
		
		return salesOrderHeader;
	}
}
