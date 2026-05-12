package HumanResources.entity;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String name;
    private LocalDate dob;
    private String address;
    private Double salary;

    private Department department;

    public Employee() {

    }
    public Employee(Integer id, String name, LocalDate dob, String address, Double salary, Department department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.salary = salary;
        this.department = department;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

}
