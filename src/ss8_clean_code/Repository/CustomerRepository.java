package ss8_clean_code.Repository;


import ss8_clean_code.Entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/ss8_clean_code/Repository/customers.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] data;
            Customer customer;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                customer = new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return customers;
    }
    public void add(Customer customer) {
        List<Customer> customers = findAll();
        customers.add(customer);
        writeFile(customers);
    }

    public void delete(int id){
        List<Customer> customers = findAll();
        customers.removeIf(c -> c.getId() == id); // Biểu thức Lambda giống như vòng lặp for
        writeFile(customers);
    }
    private void writeFile(List<Customer> customers){
        try(FileWriter fileWriter = new FileWriter("src/ss8_clean_code/Repository/customers.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (Customer customer : customers) {
                bufferedWriter.write(customer.getId() + "," + customer.getName() + "," + customer.getDob() + "," + customer.getAddress());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file");
        }
    }
    public List<Customer> findByName(String name) {
        return findAll().stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
