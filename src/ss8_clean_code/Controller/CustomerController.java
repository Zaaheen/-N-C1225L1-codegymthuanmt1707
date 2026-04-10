package ss8_clean_code.Controller;

import ss8_clean_code.Entity.Customer;
import ss8_clean_code.Service.ICustomerService;
import ss8_clean_code.Service.Imp.CustomerService;

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
