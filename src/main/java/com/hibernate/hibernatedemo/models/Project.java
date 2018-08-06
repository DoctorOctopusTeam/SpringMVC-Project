package com.hibernate.hibernatedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectID")
    private int Id;

    @Column(name = "Name")
    private String name;


    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "employeesprojects",
               joinColumns = @JoinColumn(name = "ProjectID"),
               inverseJoinColumns = @JoinColumn(name = "EmployeeID"))
    private List<Employee> employees;

    public Project() {

    }

    public Project(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
