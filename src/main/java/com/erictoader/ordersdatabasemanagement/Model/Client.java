package com.erictoader.ordersdatabasemanagement.Model;

public class Client {
    private Integer id;
    private String last_name;
    private String first_name;
    private String phone_number;
    private String address;

    public Client() {
        this.id = 0;
        this.last_name = "";
        this.first_name = "";
        this.phone_number = "";
        this.address = "";
    }

    public Client(Integer id, String lastName, String firstName, String phoneNumber, String address) {
        this.id = id;
        this.last_name = lastName;
        this.first_name = firstName;
        this.phone_number = phoneNumber;
        this.address = address;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + last_name + '\'' +
                ", firstName='" + first_name + '\'' +
                ", phoneNumber='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


