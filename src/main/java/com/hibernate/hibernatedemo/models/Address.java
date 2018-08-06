package com.hibernate.hibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int Id;

    @Column(name = "AddressText")
    private String addressText;

    @JsonIgnoreProperties("address")
    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address(){

    }

    public Address(String addressText){
        this.addressText = addressText;
    }

    public int getId() {
        return Id;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
