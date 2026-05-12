package HumanResources.service.Imp;

import HumanResources.entity.Employee;
import HumanResources.repository.EmployeeRepository;
import HumanResources.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public boolean update(int id, Employee employee) {
        return employeeRepository.update(id, employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int id) {
        return employeeRepository.getEmployeesByDepartment(id);
    }
}
