package ss8_clean_code.Repository;

import ss8_clean_code.Entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(1, "Thuan", "01/01/2000", "ĐN"));
        customers.add(new Customer(2, "Thua", "01/01/2000", "ĐN"));
        customers.add(new Customer(3, "Thu", "01/01/2000", "ĐN"));
    }
    public List<Customer> findAll(){
        return new ArrayList<>(customers);
    }
    public void add(Customer customer) {
        customers.add(customer);
    }

    public void delete(int id){
        customers.removeIf(c -> c.getId() == id); // Biểu thức Lambda giống như vòng lặp for
    }

    public List<Customer> findByName(String name) {
        return customers.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
