package HumanResources.controller;

import HumanResources.entity.Department;
import HumanResources.entity.Employee;
import HumanResources.service.IDepartmentService;
import HumanResources.service.IEmployeeService;
import HumanResources.service.Imp.DepartmentService;
import HumanResources.service.Imp.EmployeeService;

import java.util.List;

public class EmployeeController {
    private IEmployeeService employeeService = new EmployeeService();
    private IDepartmentService departmentService = new DepartmentService();
    public List<Employee> getAll(){
        List<Employee> employees = employeeService.findAll();
        return employees;
    }
    public boolean add(Employee employee){
        return employeeService.add(employee);
    }
    public boolean delete(int id){
        return employeeService.delete(id);
    }
    public boolean update(int id, Employee employee){
        return employeeService.update(id,employee);

    }
    public Employee findById(int id){
        return employeeService.findById(id);
    }
    public Department findDeptById(int id) {
        return departmentService.findById(id);
    }
    public List<Employee> getEmployeesByDepartment(int id) {
        return employeeService.getEmployeesByDepartment(id);
    }
}
