package edu.wctc.sales;

public class Sale {
    private String name;
    private String country;
    private double total;
    private double tax;
    private double shipping;

    public Sale(String name, String country, double total, double shipping) {
        this.name = name;
        this.country = country;
        this.total = total;
        this.tax = total*.05;
        this.shipping = shipping;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%1$-30s %2$-30s $%3$-10.2f $%4$-10.2f $%5$-10.2f", name, country, total, tax, shipping);
    }
}
