package model;

import java.util.Date;
import java.util.Random;

public class Product {

    String productId;
    String name;
    Date dateSupplied;

    int quantityInStock;

    double unitPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    Random random = new Random();


    Product() {
        this.productId = String.valueOf(Math.random());
        this.name = "";
        this.dateSupplied = new Date();
        this.quantityInStock = 0;
        this.unitPrice = 0.0;
    }

    Product(String name, int quantityInStock, double unitPrice) {
        this.productId = String.valueOf(Math.random());
        this.name = name;
        this.dateSupplied = new Date();
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(String productId, String name, Date dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

}
