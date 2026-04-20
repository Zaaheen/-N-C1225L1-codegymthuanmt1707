package ss12_java_collection_framework.controller;

import ss12_java_collection_framework.entity.Customer;
import ss12_java_collection_framework.service.ICustomerService;
import ss12_java_collection_framework.service.Imp.CustomerService;

import java.util.List;

public class CustomerController {
    private ICustomerService customerService = new CustomerService();

    public List<Customer> getAll() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }
    public void add(Customer customer){
        customerService.add(customer);
    }
    public void delete(int id){
        customerService.delete(id);
    }
    public List<Customer> getByName(String name) {
        List<Customer> customers = customerService.findByName(name);
        return customers;
    }
}
