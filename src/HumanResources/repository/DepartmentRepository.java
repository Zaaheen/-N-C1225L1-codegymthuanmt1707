package HumanResources.repository;

import HumanResources.entity.Department;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRepository {
    public Map<Integer, Department> findAll(){
        Map<Integer, Department> departmentMap = new HashMap<>();
        try(FileReader fileReader = new FileReader("src/HumanResources/data/department.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line;
            String[] data;
            Department department;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                department = new Department(Integer.parseInt(data[0]), data[1]);
                departmentMap.put(department.getId(),department);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return departmentMap;
    }
    public boolean add(Department department) {
        Map<Integer, Department> departmentMap = findAll();
        if (departmentMap.containsKey(department.getId())) {
            return false;
        }
        departmentMap.put(department.getId(), department);
        writeFile(departmentMap);
        return true;
    }

    public boolean delete(int id) {
        Map<Integer, Department> departmentMap = findAll();
        Department removedDept = departmentMap.remove(id);
        if (removedDept != null) {
            writeFile(departmentMap);
            return true;
        }

        return false;
    }
    public boolean update(int id, Department newDepartment) {
        Map<Integer, Department> departmentMap = findAll();
        if (!departmentMap.containsKey(id)) {
            return false;
        }
        departmentMap.put(id, newDepartment);
        writeFile(departmentMap);
        return true;
    }

    private void writeFile(Map<Integer, Department> departmentMap) {
        try (FileWriter fileWriter = new FileWriter("src/HumanResources/data/department.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Department department : departmentMap.values()) {
                bufferedWriter.write(department.getId() + "," + department.getName());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
