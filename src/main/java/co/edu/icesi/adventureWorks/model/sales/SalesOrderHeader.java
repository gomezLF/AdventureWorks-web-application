package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.Person.Contact;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "SalesOrderHeader.findAll", query = "SELECT s FROM SalesOrderHeader s")
public class SalesOrderHeader implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key for SalesOrderHeader rows.
	 * 
	 */
	@Id
	@SequenceGenerator(name = "SALESORDERHEADER_SALESORDERID_GENERATOR", allocationSize = 1, sequenceName = "SALESORDERHEADER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESORDERHEADER_SALESORDERID_GENERATOR")
	@Getter
	@Setter
	 private Integer salesOrderID;
	
	
	/**
	 * Incremental number to track changes to the sales order over time.
	 */
	@Getter
	@Setter
	 private Integer revisionNumber;
	
	
	/**
	 * Dates the sales order was created.
	 */
	@Getter
	@Setter
	 private LocalDateTime orderDate;
	
	
	/**
	 * Date the order is due to the customer.
	 */
	@Getter
	@Setter
	 private LocalDateTime dueDate;
	
	
	/**
	 * Date the order was shipped to the customer.
	 */
	@Getter
	@Setter
	 private LocalDateTime shipDate;

	
	/**
	 * Order current status.
	 */
	@Getter
	@Setter
	 private Status status;

	
	/**
	 * Reflects the person who placed the order.
	 */
	@Getter
	@Setter
	 private OrderFlag onlineOrderFlag;

	
	/**
	 * Unique sales order identification number.
	 */
	@Getter
	@Setter
	 private String salesOrderNumber;

	
	/**
	 * Customer purchase order number reference.
	 */
	@Getter
	@Setter
	 private String purchaseOrderNumber;

	
	/**
	 * Financial accounting number reference.
	 */
	@Getter
	@Setter
	 private String accountNumber;
	
	
	/**
	 * Approval code provided by the credit card company.
	 */
	@Getter
	@Setter
	private String creditCardApprovalCode;

	
	/**
	 * Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal) for the SalesOrderID.
	 */
	@Getter
	@Setter
	 private BigDecimal subTotal;

	
	/**
	 * Tax amount.
	 */
	@Getter
	@Setter
	 private BigDecimal taxAmt;

	
	/**
	 * Shipping cost.
	 */
	@Getter
	@Setter
	 private BigDecimal freight;

	
	/**
	 * Total due from customer. Computed as SubTotal + TaxAmt + Freight.
	 */
	@Getter
	@Setter
	 private BigDecimal totalDue;

	
	/**
	 * Comments made by the sales representative.
	 */
	@Getter
	@Setter
	 private String comments;

	
	/**
	 * Date the sales order header was last updated.
	 */
	@Getter
	@Setter
	 private LocalDateTime modifiedDate;

	
	/**
	 * Customer identification.
	 */
	@Getter
	@Setter
	 private Customer customer;

	
	/**
	 * Customer contact identification.
	 */
	@Getter
	@Setter
	 private Contact contact;

	
	/**
	 * Sales person who created the sales order.
	 */
	@Getter
	@Setter
	 private Salesperson salesperson;

	
	/**
	 * Territory in which the sale was made.
	 */
	@Getter
	@Setter
	 private SalesTerritory salesTerritory;

	
	/**
	 * Customer billing address.
	 */
	@Getter
	@Setter
	 private Address billToAddress;

	
	/**
	 * Customer shipping address.
	 */
	@Getter
	@Setter
	 private Address shipToAddress;

	
	/**
	 * Shipping method.
	 */
	@Getter
	@Setter
	 private ShipMethod shipMethod;

	
	/**
	 * Credit card identification.
	 */
	@Getter
	@Setter
	 private Creditcard creditcard;

	
	/**
	 * Currency exchange rate used.
	 */
	@Getter
	@Setter
	 private CurrencyRate currencyRate;
	
	
	
	public SalesOrderHeader() {
		setModifiedDate(LocalDateTime.now());
	}
	
}
