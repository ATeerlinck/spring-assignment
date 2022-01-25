package edu.wctc.sales;

import edu.wctc.sales.iface.SalesReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateCountryReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> saleList) {

        Map<String, Sale> map = new HashMap<>();

        for (Sale sale: saleList) {
            if (map.containsKey(sale.getCountry())) {
                Sale objectFromMap = map.get(sale.getCountry());
                objectFromMap.setTotal(objectFromMap.getTotal() + sale.getTotal());
                objectFromMap.setTax(objectFromMap.getTax() + sale.getTax());;
                objectFromMap.setShipping(objectFromMap.getShipping() + sale.getShipping());
                map.put(sale.getCountry(), objectFromMap);
            }
            else {
                map.put(sale.getCountry(), sale);
            }
        }

        System.out.println("Summary Sales Report");
        System.out.printf("%-30s%-10s %-10s %-10s\n", "Country", "Total", "Tax", "Shipping");
        for ( String country : map.keySet()) {
            System.out.printf("%-30s$%-10.2f$%-10.2f$%-10.2f\n", country, map.get(country).getTotal(),map.get(country).getTax() ,map.get(country).getShipping());
        }


    }
}
