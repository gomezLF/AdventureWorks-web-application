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
@NamedQuery(name = "ProductModel.findAll", query = "SELECT p FROM ProductModel P")
public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 
	 */
	@Id
	@SequenceGenerator(name = "PRODUCTMODEL_PRODUCTMODELID_GENERATOR", allocationSize = 1, sequenceName = "PRODUCTMODEL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTMODEL_PRODUCTMODELID_GENERATOR")
	@Getter
	@Setter
	private Integer productModelID;
	
	
	/**
	 * 
	 */
	@Getter
	@Setter
	private String name;

	
	/**
	 * 
	 */
	@Getter
	@Setter
	private String catalogDescription;

	
	/**
	 * 
	 */
	@Getter
	@Setter
	private String instructions;

	
	/**
	 * 
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;

	
	/**
	 * 
	 */
	@OneToMany(mappedBy = "productmodel")
	@Getter
	@Setter
	private List<Product> products;
	
	
	
	public ProductModel() {
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
		product.setProductModel(this);
		
		return product;
	}
	
}
