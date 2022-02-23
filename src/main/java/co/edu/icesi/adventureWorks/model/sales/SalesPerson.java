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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "SalesPerson.findAll", query = "SELECT s FROM SalesPerson s")
public class SalesPerson implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for SalesPerson rows.
	 */
	@Id
	@SequenceGenerator(name = "SALESPERSON_SALESPERSONID_GENERATOR", allocationSize = 1, sequenceName = "SALESPERSON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESPERSON_SALESPERSONID_GENERATOR")
	@Getter
	@Setter
	private Integer salesPersonID;
	
	
	/**
	 * Projected yearly sales.
	 */
	@Getter
	@Setter
	private BigDecimal salesQuota;
	
	
	/**
	 * Bonus due if quota is met.
	 */
	@Getter
	@Setter
	private BigDecimal bonus;
	
	
	/**
	 * Commission percent received per sale.
	 */
	@Getter
	@Setter
	private BigDecimal commissionPct;
	
	
	/**
	 * Sales total year to date.
	 */
	@Getter
	@Setter
	private BigDecimal salesYearToDate;
	
	
	/**
	 * Sales total of previous year.
	 */
	@Getter
	@Setter
	private BigDecimal salesLastYear;
	
	
	/**
	 * Date the sales person was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * List of all the sales order headers when appears the current sales person.
	 */
	@OneToMany(mappedBy = "salesperson")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	/**
	 * Territory currently assigned to. 
	 */
	@ManyToOne
	@JoinColumn(name = "territoryID")
	@Getter
	@Setter
	private SalesTerritory salesTerritory;
	
	
	/**
	 * Store where the salesperson works
	 */
	@ManyToOne
	@JoinColumn(name = "storeID")
	@Getter
	@Setter
	private Store store;
	
	
	
	public SalesPerson() {
		setSalesOrderHeaders(new ArrayList<SalesOrderHeader>());
		setModifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a sales order header, created prior to calling this function, to a sales order headers list. It then returns the added sales order header.
	 * @param salesOrderHeader - The sales order header to be added.
	 * @return The sales order header added. 
	 */
	public SalesOrderHeader addSalesorderheader(SalesOrderHeader salesOrderHeader) {
		getSalesOrderHeaders().add(salesOrderHeader);
		salesOrderHeader.setSalesperson(this);
		
		return salesOrderHeader;
	}
}
