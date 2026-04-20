package ss12_java_collection_framework.service;

import ss12_java_collection_framework.entity.Product;
import ss12_java_collection_framework.repository.ProductRepository;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    void delete(int id);
    void update(int id,Product product);
    List<Product> findByNameProduct(String name);
    void sortByPriceAsc();
    void sortByPriceDesc();
    Product findById(int id);
}
