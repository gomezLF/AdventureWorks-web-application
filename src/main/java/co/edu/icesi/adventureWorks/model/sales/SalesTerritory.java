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
	
	
	
	public SalesTerritory() {
		setCustomers(new ArrayList<Customer>());
		setModdifiedDate(LocalDateTime.now());
	}
}
