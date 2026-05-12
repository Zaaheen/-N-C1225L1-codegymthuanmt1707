package HumanResources.controller;

import HumanResources.entity.Department;
import HumanResources.service.IDepartmentService;
import HumanResources.service.Imp.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentController {
    private IDepartmentService departmentService = new DepartmentService();
    public List<Department> getAll() {
        // Lấy Map từ Service
        Map<Integer, Department> departmentMap = departmentService.findAllMap();

        // Chuyển Map.values() thành List
        return new ArrayList<>(departmentMap.values());
    }
    public boolean add(Department department){
        return departmentService.add(department);
    }
    public boolean delete(int id){
        return departmentService.delete(id);
    }
    public boolean update(int id,Department department){
        return departmentService.update(id,department);
    }
    public Department findById(int id) {
        return departmentService.findById(id);
    }
}
