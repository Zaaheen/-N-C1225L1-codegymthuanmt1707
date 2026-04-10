package ss8_clean_code.Service;

import ss8_clean_code.Entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void add(Customer customer);

    void delete(int id);

    List<Customer> findByName(String name);
}
