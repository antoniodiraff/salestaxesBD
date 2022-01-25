package it.adr.salestaxesBD;

import java.math.BigDecimal;
import java.util.List;

import it.adr.salestaxesBD.model.Item;

public class ReceiptConsole {
    private static String itemFormat = "%1$-40s %2$6.2f %n";
    private static String taxFormat = "%1$40s %2$6.2f %n";
    private static String totalFormat = "%1$40s %2$6.2f %n%n%n";

    public static void purchaseList(List<Item> items) {
    	for(Item item: items){
            System.out.format(itemFormat, item.getQuantity() 
            		+ " " + item.getName()
            		+": ", item.getTotalPrice());
        }
    }

    public static void salesTax(BigDecimal taxTotal) {
        System.out.format(taxFormat, "Sales Taxes:", taxTotal);
    }

    public static void totalSale(BigDecimal saleTotal) {
        System.out.format(totalFormat, "Total:", saleTotal);
    }

    public static void lineBreak() {
        String dashes = new String(new char[48]).replace("\0", "-");
        System.out.format(dashes+"%n");
    }
}