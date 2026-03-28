package com.abes.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name", nullable=false)
    private String customerName;

    @OneToMany(mappedBy="customer")
    private List<Order> orders;

    public Customer(){}

    public Customer(int customerId, String customerName){
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}