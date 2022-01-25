package it.adr.salestaxesBD.model;

import java.math.BigDecimal;
import it.adr.salestaxesBD.service.TaxService;


public class Item {
	
	private String name;
	private BigDecimal price;
	private ItemType itemType;
	private boolean isImported = false;
	private TaxService taxService;
	private int quantity; 

	/**
	 * Constructor for items
	 * 
	 * @param name
	 * @param itemType
	 * @param price
	 * @param taxService
	 */
	public Item(int quantity, String name, ItemType goodsType, BigDecimal shelfPrice,
			TaxService taxService,  boolean isImported) {
		this.name = name;
		this.itemType = goodsType;
		this.price = shelfPrice;
		this.taxService = taxService;
		this.isImported = isImported;
		this.quantity = quantity; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

	public BigDecimal getTax() {
		return taxService.calculateTax(this); 
	}

	public BigDecimal getTotalPrice() {
	    return getPrice().add(getTax()); 
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
