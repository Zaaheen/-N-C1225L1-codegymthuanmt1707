package ss8_clean_code.Controller;

import ss8_clean_code.Entity.Customer;
import ss8_clean_code.Service.ICustomerService;
import ss8_clean_code.Service.Imp.CustomerService;

public class CustomerController {
    private ICustomerService CustomerService = new CustomerService();

    public Customer[] getAll() {
        Customer[] customers = CustomerService.findAll();
        return customers;
    }
}
