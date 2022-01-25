package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.SalesReport;

import java.util.List;


public class GenerateAllReport implements SalesReport {

    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("Total Sales Report");
        System.out.printf("%-30s %-30s %-10s  %-10s  %-10s\n", "Customer", "Country", "Total", "Tax", "Shipping");
        for (int i = 0; i<salesList.size(); i++) {
            System.out.println(salesList.get(i));
        }

    }
}
