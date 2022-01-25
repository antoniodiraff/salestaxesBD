package it.adr.salestaxesBD.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tax {

	private BigDecimal rate;
	
	/**
	 * Constructor
	 * 
	 */
	public Tax(BigDecimal rate) {
		super();
		this.rate = rate;
	}
	
	public BigDecimal getTax(BigDecimal itemPrice) {
		BigDecimal seed = new BigDecimal("0.05");
		BigDecimal taxPrice =  itemPrice.multiply(rate); 
		return taxPrice.divide(seed).setScale(0, RoundingMode.UP).multiply(seed);
	}
}
