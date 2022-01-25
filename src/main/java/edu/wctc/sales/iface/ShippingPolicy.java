package edu.wctc.sales.iface;

import edu.wctc.sales.Sale;

public interface ShippingPolicy {
    Sale applyShipping(Sale sale);
}
