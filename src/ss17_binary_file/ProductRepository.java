package ss17_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        File file = new File("src/ss17_binary_file/product.dat");
        if (!file.exists() || file.length() == 0) {
            return products;
        }
        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
                products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found");
        }
        return products;
    }
    public boolean add(Product product){
        List<Product> products = findAll();
        boolean isExist = products.stream().anyMatch(p -> p.getId() == product.getId());
        if (isExist){
            return false;
        }
        products.add(product);
        writeFile(products);
        return true;
    }
    public List<Product> findByName(String name) {
        List<Product> products = findAll();
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
    private void writeFile(List<Product> products){
        try (OutputStream outputStream = new FileOutputStream("src/ss17_binary_file/product.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            System.err.println("Error writing file");
        }
    }
}
