package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.person.Address;
import co.edu.icesi.adventureWorks.model.person.Contact;
import co.edu.icesi.adventureWorks.model.purchasing.ShipMethod;
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
	@ManyToOne
	@JoinColumn(name = "customerID")
	@Getter
	@Setter
	 private Customer customer;

	
	/**
	 * Customer contact identification.
	 */
	@ManyToOne
	@JoinColumn(name = "contactID")
	@Getter
	@Setter
	 private Contact contact;
	
	
	/**
	 * Sales person who created the sales order.
	 */
	@ManyToOne
	@JoinColumn(name = "salesPersonID")
	@Getter
	@Setter
	 private SalesPerson salesperson;

	
	/**
	 * Territory in which the sale was made.
	 */
	@ManyToOne
	@JoinColumn(name = "territoryID")
	@Getter
	@Setter
	 private SalesTerritory salesTerritory;

	
	/**
	 * Customer billing address.
	 */
	@ManyToOne
	@JoinColumn(name = "addressID")
	@Getter
	@Setter
	 private Address billToAddress;

	
	/**
	 * Customer shipping address.
	 */
	@ManyToOne
	@JoinColumn(name = "addressID")
	@Getter
	@Setter
	 private Address shipToAddress;

	
	/**
	 * Shipping method.
	 */
	@ManyToOne
	@JoinColumn(name = "shipMethodID")
	@Getter
	@Setter
	 private ShipMethod shipMethod;

	
	/**
	 * Credit card identification.
	 */
	@ManyToOne
	@JoinColumn(name = "creditCardID")
	@Getter
	@Setter
	 private CreditCard creditcard;
	
	
	/**
	 * Currency exchange rate used.
	 */
	@ManyToOne
	@JoinColumn(name = "currencyRateID")
	@Getter
	@Setter
	 private CurrencyRate currencyRate;
	
	
	
	public SalesOrderHeader() {
		setModifiedDate(LocalDateTime.now());
	}
	
}
