package co.edu.icesi.adventureWorks.model.production;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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

import co.edu.icesi.adventureWorks.model.sales.SalesOrderDetail;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for Product rows.
	 */
	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
	@Getter
	@Setter
	private Integer productID;
	
	
	/**
	 * Primary key for Product rows.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Unique product identification number.
	 */
	@Getter
	@Setter
	private String productNumber;
	
	
	/**
	 * Flag indicating whether the product is produced in-house or purchased.
	 */
	@Getter
	@Setter
	private MakeFlag makeFlag;
	
	
	/**
	 * Flag indicating whether the product can be sold or not.
	 */
	@Getter
	@Setter
	private FinishedGoodsFlag finishedGoodsFlag;
	
	
	/**
	 * Product color.
	 */
	@Getter
	@Setter
	private String color;
	
	
	/**
	 * Minimum inventory quantity.
	 */
	@Getter
	@Setter
	private Integer safetyStockLevel;
	
	
	/**
	 * Inventory level that triggers a purchase order or work order.
	 */
	@Getter
	@Setter
	private Integer reorderPoint;
	
	
	/**
	 * Standard cost of the product.
	 */
	@Getter
	@Setter
	private BigDecimal standardCost;
	
	
	/**
	 * Selling price.
	 */
	@Getter
	@Setter
	private BigDecimal listPrice;
	
	
	/**
	 * Product size.
	 */
	@Getter
	@Setter
	private String size;
	
	
	/**
	 * Product weight.
	 */
	@Getter
	@Setter
	private Double wheight;
	
	
	/**
	 * Unit of measure for Size column.
	 */
	@Getter
	@Setter
	private String sizeUnitMeasureCode;
	
	
	/**
	 * Unit of measure for Weight column.
	 */
	@Getter
	@Setter
	private String weightUnitMeasureCode;
	
	
	/**
	 * Number of days required to manufacture the product.
	 */
	@Getter
	@Setter
	private Integer daysToManufacture;
	
	
	/**
	 * 
	 */
	@Getter
	@Setter
	private ProductLineType productLine;
	
	
	/**
	 * Flag indicating for which class (upper, middle, lower) of the population the product is intended for.
	 */
	@Getter
	@Setter
	private ClassType procutClass;
	
	
	/**
	 * Flag indicating for which sex of the population the product is intended.
	 */
	@Getter
	@Setter
	private StyleType productStyle;
	
	
	/**
	 * Date the product was available for sale.
	 */
	@Getter
	@Setter
	private LocalDate sellStartDate;
	
	
	/**
	 * Date the product was no longer available for sale.
	 */
	@Getter
	@Setter
	private LocalDate sellEndDate;
	
	
	/**
	 * Date time the product was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * Product is a member of this product subcategory.
	 */
	@ManyToOne
	@JoinColumn(name = "productSubcategoryID")
	@Getter
	@Setter
	private ProductSubCategory productSubCategory;
	
	
	/**
	 * Product is a member of this product model.
	 */
	@Getter
	@Setter
	private ProductModel productModel;
	
	
	/**
	 * List of all sales details containing the current product.
	 */
	@OneToMany(mappedBy = "product")
	@Getter
	@Setter
	private List<SalesOrderDetail> salesOrderDetails;
	
	
	
	public Product() {
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
		salesOrderDetail.setProduct(this);
		
		return salesOrderDetail;
	}
}
