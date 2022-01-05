package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c")
public class CreditCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for CreditCard rows.
	 */
	@Getter
	@Setter
	private Integer creditCardID;
	
	
	/**
	 * Credit card name.
	 */
	@Getter
	@Setter
	private CardType cardType;
	
	
	/**
	 * Credit card number.
	 */
	@Getter
	@Setter
	private String cardNumber;
	
	
	/**
	 * Credit card expiration month.
	 */
	@Getter
	@Setter
	private Integer expMonth;
	
	
	/**
	 * Credit card expiration year.
	 */
	@Getter
	@Setter
	private Integer expYear;
	
	
	/**
	 * Date the credit card was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * List of all the sales order headers that use the current credit card.
	 */
	@OneToMany(mappedBy = "creditcard")
	@Getter
	@Setter
	private List<SalesOrderHeader> salesOrderHeaders;
	
	
	
	public CreditCard() {
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
		salesOrderHeader.setCreditcard(this);
		
		return salesOrderHeader;
	}
}
