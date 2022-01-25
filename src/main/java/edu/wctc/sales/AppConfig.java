package edu.wctc.sales;

import edu.wctc.sales.iface.ShippingPolicy;
import edu.wctc.sales.iface.SalesInput;
import edu.wctc.sales.iface.SalesReport;
import edu.wctc.sales.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc.sales")
public class AppConfig {
    @Bean
    public SalesReport salesReport() {
        return new GenerateAllReport();
//        return new PopupOutput();
    }

    @Bean
    public SalesInput salesInput() {
        return new GetSales();
//        return new PopupInput();
    }

    @Bean
    public ShippingPolicy shippingPolicy() {
        return new ApplyFreeShipping();
//        return new PopupInput();
    }
}
