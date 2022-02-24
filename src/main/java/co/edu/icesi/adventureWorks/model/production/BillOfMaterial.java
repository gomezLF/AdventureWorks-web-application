package co.edu.icesi.adventureWorks.model.production;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "BillOfMaterial.findAll", query = "SELECT b FROM BillOfMaterial b")
public class BillOfMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for BillOfMaterials rows.
	 */
	@Id
	@SequenceGenerator(name = "BILLOFMATERIAL_BILLOFMATERIALSID_GENERATOR", allocationSize = 1, sequenceName = "BILLOFMATERIAL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILLOFMATERIAL_BILLOFMATERIALSID_GENERATOR")
	@Getter
	@Setter
	private Integer billOfMaterialsID;
	
	
	/**
	 * Date the component started being used in the assembly item.
	 */
	@Getter
	@Setter
	private LocalDate startDate;
	
	
	/**
	 * Date the component stopped being used in the assembly item.
	 */
	@Getter
	@Setter
	private LocalDate endDate;
	
	
	/**
	 * Standard code identifying the unit of measure for the quantity.
	 */
	@Getter
	@Setter
	private String UnitMeasureCode;
	
	
	/**
	 * Indicates the depth the component is from its parent (ProductAssemblyID).
	 */
	@Getter
	@Setter
	private Integer BOMLevel;
	
	
	/**
	 * Quantity of the component needed to create the assembly.
	 */
	@Getter
	@Setter
	private Double perAssemblyQty;
	
	
	/**
	 * Date the class was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * Parent product identification number. 
	 */
	@Getter
	@Setter
	private Product productAssembly; 
	
	
	/**
	 * Component identification number. 
	 */
	@Getter
	@Setter
	private Product component;
	
	
	
	public BillOfMaterial() {
		setModifiedDate(LocalDate.now());
	}
}
