package it.adr.salestaxesBD;

import java.math.BigDecimal;
import it.adr.salestaxesBD.model.Item;
import it.adr.salestaxesBD.model.ItemType;
import it.adr.salestaxesBD.model.Purchase;
import it.adr.salestaxesBD.serviceImpl.TaxServiceImpl;




/**
 * Sales Taxes
 *
 */
public class Start 
{
	private static TaxServiceImpl tc = new TaxServiceImpl();

    public static void main( String[] args )
    {
    	inputOne();
		inputTwo();
		inputThree();
    }
    
    
    private static void inputOne() {
		Item book = new Item(2,"book", ItemType.BOOK, new BigDecimal("12.49"),tc, false);
		Item musicCD = new Item(1, "music CD", ItemType.MUSIC, new BigDecimal("14.99"), tc, false);
		Item chocolateBar = new Item(1, "chocolate bar", ItemType.FOOD, new BigDecimal("0.85"), tc, false);
		receipt(book, musicCD, chocolateBar);
	}

	private static void inputTwo() {
		Item importedChocolate = new Item(1, "box of chocolates (imported)", ItemType.FOOD, new BigDecimal("10"),  tc, true);
		Item importedPerfume = new Item(1, "bottle of perfume (imported)", ItemType.PERFUME, new BigDecimal("47.5"),  tc, true);
		receipt(importedChocolate, importedPerfume);
	}

	private static void inputThree() {
		Item importedPerfumeAnother = new Item(1, "bottle of perfume (imported)",ItemType.PERFUME, new BigDecimal("27.99"), tc, true);
		Item perfume = new Item(1, "bottle of perfume", ItemType.PERFUME, new BigDecimal("18.99"), tc, false);
		Item headachePills = new Item(1, "packet of headache pills", ItemType.MEDICAL, new BigDecimal("9.75"), tc, false);
		Item importedChocolateAnother = new Item(1, "box of chocolates (imported)", ItemType.FOOD, new BigDecimal("11.25"), tc, true);
		receipt(importedPerfumeAnother, perfume, headachePills,importedChocolateAnother);
	}

	private static void receipt(Item... items) {
		if (items == null)
			return;
		Purchase purchase = new Purchase();
		for (Item i : items) {
			purchase.addItem(i);
		}
		
		ReceiptConsole.purchaseList(purchase.getItemList());
		ReceiptConsole.lineBreak();       
        ReceiptConsole.salesTax(purchase.totTax());
        ReceiptConsole.totalSale(purchase.totPrice());
	}
}
