package ss12_java_collection_framework.repository;

import ss12_java_collection_framework.compare.CompareProduct;
import ss12_java_collection_framework.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Áo thun", 150000.0));
        products.add(new Product(2, "Quần Jean", 350000.0));
        products.add(new Product(3, "Áo khoác", 500000.0));
    }
    public List<Product> findAll(){
        return new ArrayList<>(products);
    }
    public void add(Product product) {
        products.add(product);
    }
    public void delete(int id){
        products.removeIf(c -> c.getId() == id);
    }
    public List<Product> findByNameProduct(String name) {
        return products.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public void update(int id, Product newProduct){
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                return;
            }
        }
    }
    public void sortByPriceAsc(){
        products.sort(new CompareProduct());
    }
    public void sortByPriceDesc(){
        products.sort(new CompareProduct().reversed());
    }
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
