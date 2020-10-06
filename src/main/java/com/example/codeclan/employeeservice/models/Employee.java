package com.example.codeclan.employeeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "employee_number")
    private int employeeNumber;


    @ManyToOne
            @JoinColumn(name="department_id",nullable = false)
    private Department department;



    @JsonIgnoreProperties({"employees"})
    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = { @JoinColumn(name ="employee_id",
                    nullable = false,
                    updatable  =false)
            },
            inverseJoinColumns = {@JoinColumn(name ="project_id",
                    nullable = false,
                    updatable  =false) }

    )

    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(String name, int employeeNumber, Department department) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addProject(Project project){
         projects.add(project);
    }

    public Employee(){


    }
}
