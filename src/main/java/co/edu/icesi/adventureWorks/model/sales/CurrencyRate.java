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
@NamedQuery(name = "CurrencyRate.findAll", query = "SELECT c FROM CurrencyRate c")
public class CurrencyRate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for CurrencyRate rows.
	 */
	@Id
	@SequenceGenerator(name = "CURRENCYRATE_CURRENCYRATEID_GENERATOR", allocationSize = 1, sequenceName = "CURRENCYRATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCYRATE_CURRENCYRATEID_GENERATOR")
	@Getter
	@Setter
	private Integer currencyRateID;

	
	/**
	 * Date the exchange rate was obtained.
	 */
	@Getter
	@Setter
	private LocalDateTime currencyRateDate;

	
	/**
	 * Currency code from which the exchange rate was converted.
	 */
	@Getter
	@Setter
	private String fromCurrencyCode;

	
	/**
	 * Currency code to which the exchange rate was converted.
	 */
	@Getter
	@Setter
	private String toCurrencyCode;

	
	/**
	 * Average exchange rate for the day.
	 */
	@Getter
	@Setter
	private BigDecimal averageRate;

	
	/**
	 * Final exchange rate for the day.
	 */
	@Getter
	@Setter
	private BigDecimal endOfDayRate;

	
	/**
	 * Date the currency rate was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;

	
	/**
	 * List of all the sales order headers that use the current currency rate.
	 */
	@OneToMany(mappedBy = "currencyrate")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	
	public CurrencyRate() {
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
		salesOrderHeader.setCurrencyRate(this);
		
		return salesOrderHeader;
	}
}
