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
	
	/**
	 * get amount of tax by a given price rounding up the result
	 * 
	 * RoundingMode.UP
	 * 
     * Rounding mode to round away from zero.  Always increments the
     * digit prior to a non-zero discarded fraction.  Note that this
     * rounding mode never decreases the magnitude of the calculated
     * value.
	 * 
	 * 
	 * 
	 * 
	 */
	public BigDecimal getTax(BigDecimal itemPrice) {
		BigDecimal seed = new BigDecimal("20");
		BigDecimal taxPrice =  itemPrice.multiply(rate); 
		return taxPrice.multiply(seed).setScale(0, RoundingMode.UP).divide(seed);
	}
}
