package it.adr.salestaxesBD.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


public class TaxCollection {

	private List<Tax> taxList;

	/**
	 * Constructor
	 */
	public TaxCollection () {
		taxList = new LinkedList<Tax>();
	}
	
	/**
	 * add a Tax to the List
	 * 
	 */
	public void addTax(Tax tax) {
		this.taxList.add(tax);
	}
	
	public List<Tax> getTaxList() {
		return this.taxList;
	}
	
	public BigDecimal getTax(BigDecimal itemPrice) {
		BigDecimal totalTax = BigDecimal.ZERO;
		for (Tax tax : this.taxList) {
			totalTax = totalTax.add(tax.getTax(itemPrice));
		}
		return totalTax;
	}
}
