package com.erictoader.ordersdatabasemanagement.Model;

public class Product {
    private Integer id;
    private String name;
    private Integer stock;
    private Integer price;

    public Product() {
        this.id = 0;
        this.name = "";
        this.stock = 0;
        this.price = 0;
    }

    public Product(Integer id, String name, Integer stock, Integer price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
