package ss8_clean_code.Repository;

import ss8_clean_code.Entity.Customer;

public class CustomerRepository {
    private static Customer[] customers = new Customer[10];
    static {
        customers[0] = new Customer(1, "Thuan", "01/01/2000", "ĐN" );
        customers[1] = new Customer(2, "Thuan", "01/01/2000", "ĐN" );
        customers[2] = new Customer(3, "Thuan", "01/01/2000", "ĐN" );
        customers[3] = new Customer(4, "Thuan", "01/01/2000", "ĐN" );
        customers[4] = new Customer(5, "Thuan", "01/01/2000", "ĐN" );
        customers[5] = new Customer(6, "Thuan", "01/01/2000", "ĐN" );
        customers[6] = new Customer(7, "Thuan", "01/01/2000", "ĐN" );
        customers[7] = new Customer(8, "Thuan", "01/01/2000", "ĐN" );
        customers[8] = new Customer(9, "Thuan", "01/01/2000", "ĐN" );
        customers[9] = new Customer(10, "Thuan", "01/01/2000", "ĐN" );
    }
    public Customer[] findAll(){
        return customers;
    }
}
