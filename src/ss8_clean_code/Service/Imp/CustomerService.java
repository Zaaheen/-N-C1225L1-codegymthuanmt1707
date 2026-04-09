package ss8_clean_code.Service.Imp;

import ss8_clean_code.Entity.Customer;
import ss8_clean_code.Repository.CustomerRepository;
import ss8_clean_code.Service.ICustomerService;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public Customer[] findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add() {

    }

    @Override
    public void delete(int id) {

    }
}
