package HumanResources.service;

import HumanResources.entity.Department;

import java.util.Map;

public interface IDepartmentService extends IService<Department>{
    Map<Integer, Department> findAllMap();
}
