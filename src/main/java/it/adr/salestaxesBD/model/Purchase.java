package it.adr.salestaxesBD.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Purchase {

	private List<Item> itemList;

	/**
	 * Constructor
	 * 
	 */
	public Purchase() {
		this.itemList = new LinkedList<Item>();
	}

	/**
	 * getter
	 * 
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * add a new item to the Purchase
	 * 
	 * @param goods
	 */
	public void addItem(Item item) {
		this.itemList.add(item);
	}

	/**
	 * get total taxes of all items
	 * 
	 * @return
	 */
	public BigDecimal totTax() {
		BigDecimal totalTaxes = new BigDecimal("0.00");
		for (Item item : this.itemList) {
			totalTaxes = totalTaxes.add(item.getTax().multiply(BigDecimal.valueOf(item.getQuantity())));
		}
		return totalTaxes;
	}

	/**
	 * get total price with tax of all items
	 * 
	 * @return
	 */
	public BigDecimal totPrice() {
		BigDecimal totalPrice = new BigDecimal("0.00");
		for (Item item : getItemList()) {
			totalPrice = totalPrice.add(item.getTotalPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
		}
		return totalPrice;
	}

}
