package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@NamedQuery(name = "SpecialOffer.findAll", query = "SELECT s FROM SpecialOffer s")
public class SpecialOffer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for SpecialOffer rows.
	 */
	@Id
	@SequenceGenerator(name = "SPECIALOFFER_SPECIALOFFERID_GENERATOR", allocationSize = 1, sequenceName = "SPECIALOFFER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPECIALOFFER_SPECIALOFFERID_GENERATOR")
	@Getter
	@Setter
	private Integer specialOfferID;
	
	
	/**
	 * Discount description.
	 */
	@Getter
	@Setter
	private String description;

	
	/**
	 * Discount percentage.
	 */
	@Getter
	@Setter
	private BigDecimal discountPct;

	
	/**
	 * Discount type category.
	 */
	@Getter
	@Setter
	private String type;

	
	/**
	 * Group the discount applies to such as Reseller or Customer.
	 */
	@Getter
	@Setter
	private String category;

	
	/**
	 * Discount start date.
	 */
	@Getter
	@Setter
	private LocalDate startDate;

	
	/**
	 * Discount end date.
	 */
	@Getter
	@Setter
	private LocalDate endDate;

	
	/**
	 * Minimum discount percent allowed.
	 */
	@Getter
	@Setter
	private Integer minQty;

	
	/**
	 * Maximum discount percent allowed.
	 */
	@Getter
	@Setter
	private Integer maxQty;

	
	/**
	 * Date the special offer was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;

	
	/**
	 * List of all sales details that have this special offer applied. 
	 */
	@OneToMany(mappedBy = "specialoffer")
	@Getter
	@Setter
	private List<SalesOrderDetail> salesOrderDetails;
	
	
	
	public SpecialOffer() {
		setSalesOrderDetails(new ArrayList<SalesOrderDetail>());
		setModifiedDate(LocalDate.now());
	}
	
	
	
	/**
	 * Adds a sales order detail, created prior to calling this function, to a sales order details list. It then returns the added sales order detail.
	 * @param salesOrderDetail - The sales order detail to be added.
	 * @return The sales order detail added. 
	 */
	public SalesOrderDetail addSalesOrderDetail(SalesOrderDetail salesOrderDetail) {
		getSalesOrderDetails().add(salesOrderDetail);
		salesOrderDetail.setSpecialOffer(this);
		
		return salesOrderDetail;
	}
	
}
