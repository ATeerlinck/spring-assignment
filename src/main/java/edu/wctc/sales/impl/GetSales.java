package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.SalesInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GetSales implements SalesInput {
    File file = new File("sales.txt");
    String path = file.getAbsolutePath();
    private Scanner snaccer;

    {
        try {
            snaccer = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        while(snaccer.hasNextLine()){
            String line = snaccer.nextLine();
            String[] str = line.split(",");
            sales.add(new Sale(str[0],str[1],Double.parseDouble(str[2]),Double.parseDouble(str[3])));
        }
        return sales;
    }
}
