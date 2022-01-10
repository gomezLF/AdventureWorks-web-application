package co.edu.icesi.adventureWorks.model.production;

import java.io.Serializable;
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
@NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory P")
public class ProductCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for ProductCategory rows.
	 */
	@Id
	@SequenceGenerator(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTCATEGORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTCATEGORY_PRODUCTCATEGORYID_GENERATOR")
	@Getter
	@Setter
	private Integer productCategoryID;
	
	
	/**
	 * Category description.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Date the product category was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * List of all products subcategory belonging to this category.
	 */
	@OneToMany(mappedBy = "productcategory")
	@Getter
	@Setter
	private List<ProductSubCategory> productSubCategories;
	
	
	
	public ProductCategory() {
		setProductSubCategories(new ArrayList<ProductSubCategory>());
		setModifiedDate(LocalDate.now());
	}
	
	
	
	/**
	 * Adds a product subcategory, created prior to calling this function, to a product list. It then returns the added product subcategory.
	 * @param productSubCategory - The product subcategory to be added.
	 * @return The product subcategory added. 
	 */
	public ProductSubCategory addProductSubCategory(ProductSubCategory productSubCategory) {
		getProductSubCategories().add(productSubCategory);
		productSubCategory.setProductCategory(this);
		
		return productSubCategory;
	}
}
