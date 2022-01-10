package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Setter;

import lombok.Getter;

@Entity
@NamedQuery(name = "SalesOrderDetail.findAll" , query = "SELECT s FROM SalesOrderDetail s")
public class SalesOrderDetail implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key. A sequential number used to ensure data uniqueness.
	 */
	@Id
	@SequenceGenerator(name = "SALESORDERDETAIL_SALESORDERDETAILID_GENERATOR", allocationSize = 1, sequenceName = "SALESORDERDETAIL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALESORDERDETAIL_SALESORDERDETAILID_GENERATOR")
	@Getter
	@Setter
	private Integer salesOrderDetailID;
	
	
	/**
	 * Shipment tracking number supplied by the shipper.
	 */
	@Getter
	@Setter
	private String carrierTrackingNumber;
	
	
	/**
	 * Quantity ordered per product.
	 */
	@Getter
	@Setter
	private Integer orderQty;
	
	
	/**
	 * Selling price of a single product.
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	
	
	/**
	 * Discount amount.
	 */
	@Getter
	@Setter
	private BigDecimal unitPriceDiscount;
	
	
	/**
	 * Per product subtotal, Computed as OrderQty * UnitPrice.
	 */
	@Getter
	@Setter
	private BigDecimal lineTotal;
	
	
	/**
	 * Date the Sales order detail was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * Sales header to which the sales details belong.
	 */
	@ManyToOne
	@JoinColumn(name = "salesOrderID")
	@Getter
	@Setter
	private SalesOrderHeader salesOrderHeader;
	
	
	/**
	 * Product sold to customer.
	 */
	@Getter
	@Setter
	private Product product;
	
	
	/**
	 * Promotional code.
	 */
	@Getter
	@Setter
	private SpecialOffer specialOffer;
	
	
	
	public SalesOrderDetail() {
		setModifiedDate(LocalDate.now());
	}
	
	
	
}
