package com.erictoader.ordersdatabasemanagement.Model;

public class Orders {
    private Integer id;
    private Integer id_client;
    private Integer id_product;
    private Integer quantity;

    public Orders() {
        this.id = 0;
        this.id_client = 0;
        this.id_product = 0;
        this.quantity = 0;
    }

    public Orders(Integer id, Integer id_client, Integer id_product, Integer quantity) {
        this.id = id;
        this.id_client = id_client;
        this.id_product = id_product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_client() {
        return id_client;
    }

    public Integer getId_product() {
        return id_product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", id_client=" + id_client +
                ", id_product=" + id_product +
                ", quantity=" + quantity +
                '}';
    }
}
