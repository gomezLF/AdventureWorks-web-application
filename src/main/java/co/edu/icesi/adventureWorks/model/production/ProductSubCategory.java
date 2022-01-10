package co.edu.icesi.adventureWorks.model.production;

import java.io.Serializable;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p")
public class ProductSubCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for ProductSubcategory rows.
	 */
	@Id
	@SequenceGenerator(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTSUBCATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID_GENERATOR")
	@Getter
	@Setter
	private Integer productSubcategoryID;
	
	
	/**
	 * Subcategory description.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Date the product subcategory was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * Product category to which this subcategory belongs.
	 */
	@ManyToOne
	@JoinColumn(name = "productCategoryID")
	@Getter
	@Setter
	private ProductCategory productCategory;
	
	
	/**
	 * List of all products belonging to this subcategory.
	 */
	@OneToMany(mappedBy = "productsubcategory")
	@Getter
	@Setter
	private List<Product> products;
	
	
	
	public ProductSubCategory() {
		setProducts(new ArrayList<Product>());
		setModifiedDate(LocalDate.now());
	}
	
	
	
	/**
	 * Adds a product, created prior to calling this function, to a product list. It then returns the added product.
	 * @param product - The product to be added.
	 * @return The product added. 
	 */
	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductSubCategory(this);
		
		return product;
	}
	
}
