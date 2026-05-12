package HumanResources.repository;

import HumanResources.entity.Department;
import HumanResources.entity.Employee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private Map<Integer, Department> departmentMap;
    public EmployeeRepository(){
        this.departmentMap = new DepartmentRepository().findAll();
    }
    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        try(FileReader fileReader = new FileReader("src/HumanResources/data/employee.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line;
            String[] data;
            Employee employee;
            Department department;
            int departmentId;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                departmentId = Integer.parseInt(data[5]);
                department = departmentMap.get(departmentId);
                employee = new Employee(Integer.parseInt(data[0]), data[1],
                        LocalDate.parse(data[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        data[3], Double.parseDouble(data[4]), department);
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return employees;
    }
    public boolean add(Employee employee) {
        List<Employee> employees = findAll();
        boolean isExist = employees.stream().anyMatch(e -> e.getId() == employee.getId());
        if (isExist) {
            return false;
        }
        employees.add(employee);
        writeFile(employees);
        return true;
    }

    public boolean delete(int id) {
        List<Employee> employees = findAll();
        if (employees.removeIf(e -> e.getId() == id)) {
            writeFile(employees);
            return true;
        }
        return false;
    }
    public boolean update(int id, Employee newEmployee) {
        List<Employee> employees = findAll();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id){
                employees.set(i, newEmployee);
                writeFile(employees);
                return true;
            }
        }
        return false;
    }
    public Employee findById(int id) {
        List<Employee> employees = findAll();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        List<Employee> allEmployees = findAll();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getDepartment() != null && employee.getDepartment().getId() == departmentId) {
                result.add(employee);
            }
        }
        return result;
    }

    private void writeFile(List<Employee> employees) {
        try (FileWriter fileWriter = new FileWriter("src/HumanResources/data/employee.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Employee employee : employees) {
                bufferedWriter.write(formatWriteFile(employee));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
    private String formatWriteFile(Employee employee){
        String date = employee.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return employee.getId() + "," + employee.getName() + "," + date + "," + employee.getAddress() + "," + employee.getSalary() + "," + employee.getDepartment().getId();
    }


}
