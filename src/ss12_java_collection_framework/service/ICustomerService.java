package ss12_java_collection_framework.service;

import ss12_java_collection_framework.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void add(Customer customer);

    void delete(int id);

    List<Customer> findByName(String name);
}
