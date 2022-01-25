package it.adr.salestaxesBD.serviceImpl;

import java.math.BigDecimal;

import it.adr.salestaxesBD.model.Item;
import it.adr.salestaxesBD.model.Tax;
import it.adr.salestaxesBD.model.TaxCollection;
import it.adr.salestaxesBD.service.TaxService;

public class TaxServiceImpl implements TaxService{

	@Override
	public BigDecimal calculateTax(Item item) {
		
		TaxCollection taxes = new TaxCollection();
		taxes.addTax(new Tax(item.getItemType().getBasicTaxRate()));
		
		if (item.isImported())
			taxes.addTax(new Tax(new BigDecimal("0.05")));
		
		return taxes.getTax(item.getPrice());
	}

}
