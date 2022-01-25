package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ShippingPolicy;

public class ApplyAmountShipping implements ShippingPolicy {
    @Override
    public Sale applyShipping(Sale sale) {
        if(sale.getTotal()>= 60)
        sale.setShipping(0.00);
        return sale;
    }
}