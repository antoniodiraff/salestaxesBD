package it.adr.salestaxesBD.model;

import java.math.BigDecimal;

public enum ItemType {

	BOOK(BigDecimal.ZERO),
	FOOD(BigDecimal.ZERO),
	MEDICAL(BigDecimal.ZERO),
	PERFUME,
	MUSIC, 
	OTHER;
	
	private BigDecimal basicTaxRate;

	
	ItemType(BigDecimal basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

	ItemType() {
		this.setBasicTaxRate(new BigDecimal("0.1"));
	}

	public BigDecimal getBasicTaxRate() {
		return basicTaxRate;
	}

	public void setBasicTaxRate(BigDecimal basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}
}
