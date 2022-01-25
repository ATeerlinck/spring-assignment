package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ShippingPolicy;

public class ApplyFreeShipping implements ShippingPolicy {
    @Override
    public Sale applyShipping(Sale sale) {
        sale.setShipping(0.00);
        return sale;
    }
}
