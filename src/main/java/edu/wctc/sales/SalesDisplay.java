package edu.wctc.sales;

import edu.wctc.sales.iface.ShippingPolicy;
import edu.wctc.sales.iface.SalesInput;
import edu.wctc.sales.iface.SalesReport;
import edu.wctc.sales.impl.ApplyAmountShipping;
import edu.wctc.sales.impl.ApplyFreeShipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class SalesDisplay {
    private SalesInput in;
    private SalesReport out;
    private ShippingPolicy shippingPolicy;

    private List<Sale> sales = new ArrayList<>();


    @Autowired

    public SalesDisplay(SalesInput in, SalesReport out, ShippingPolicy shippingPolicy, List<Sale> sales) {
        this.in = in;
        this.out = out;
        this.shippingPolicy = shippingPolicy;
        this.sales = sales;
    }

    public void Main() {
        String input = "r";
        Scanner snaccer = new Scanner(System.in);
        while(true){
            System.out.println("enter name of customer (input q to quit)");
            input = snaccer.nextLine();
            if (Objects.equals(input, "q")){
                break;
            }
            String name = input;
            System.out.println("enter country of customer");
            input = snaccer.nextLine();
            String country = input;
            System.out.println("enter total of customer's sale");
            input = snaccer.nextLine();
            double total = Double.parseDouble(input);
            System.out.println("enter shipping of customer's sale");
            input = snaccer.nextLine();
            double shipping = Double.parseDouble(input);

            Sale sale = new Sale(name, country, total, shipping);
            sales.add(sale);
        }
        sales.addAll(in.getSales());
        System.out.println("1. regular shipping \n2. shipping is free over $60 \n3. shipping is free \n(defaults to option 1)");
        input = snaccer.nextLine();
        switch (input){
            case "2": for(Sale s: sales){
                shippingPolicy = new ApplyAmountShipping();
                shippingPolicy.applyShipping(s);
            }
            case "3": for(Sale s: sales){
                shippingPolicy = new ApplyFreeShipping();
                shippingPolicy.applyShipping(s);
            }
                break;
            case "1":
            default:
                break;
        }
        System.out.println("1. individual sales \n2. Sales by country \n(defaults to option 1)");
        input = snaccer.nextLine();
        switch (input){
            case "2": out = new GenerateCountryReport();
                break;
            case "1":
            default:
                break;
        }

        out.generateReport(sales);
    }

}
