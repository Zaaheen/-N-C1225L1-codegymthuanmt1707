package ss8_clean_code.Service;

import ss8_clean_code.Entity.Customer;

public interface ICustomerService {
    Customer[] findAll();

    void add();

    void delete(int id);
}
