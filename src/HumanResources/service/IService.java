package HumanResources.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(int id);
    boolean update(int id,T t);
    T findById(int id);
}
