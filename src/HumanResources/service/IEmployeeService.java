package HumanResources.service;

import HumanResources.entity.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee>{
    List<Employee> getEmployeesByDepartment(int id);
}
