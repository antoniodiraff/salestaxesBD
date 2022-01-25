package it.adr.salestaxesBD.service;

import java.math.BigDecimal;

import it.adr.salestaxesBD.model.Item;


public interface TaxService {

	BigDecimal calculateTax(Item item);

}
