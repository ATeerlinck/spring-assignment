package edu.wctc.sales.iface;

import edu.wctc.sales.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList);
}
