package HumanResources.service.Imp;

import HumanResources.entity.Department;
import HumanResources.repository.DepartmentRepository;
import HumanResources.service.IDepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentService implements IDepartmentService {
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    @Override
    public Map<Integer, Department> findAllMap() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findAll() {
        return new ArrayList<>(departmentRepository.findAll().values());
    }

    @Override
    public boolean add(Department department) {
        return departmentRepository.add(department);
    }

    @Override
    public boolean delete(int id) {
        return departmentRepository.delete(id);
    }

    @Override
    public boolean update(int id, Department department) {
        return departmentRepository.update(id, department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findAll().get(id);
    }
}
