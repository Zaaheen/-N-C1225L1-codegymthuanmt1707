package ss12_java_collection_framework.controller;

import ss12_java_collection_framework.entity.Product;
import ss12_java_collection_framework.service.IProductService;
import ss12_java_collection_framework.service.Imp.ProductService;

import java.util.List;

public class ProductController {
    private IProductService productService = new ProductService();
    public List<Product> getAll() {
        List<Product> products = productService.findAll();
        return products;
    }

    public void add(Product product) {
        productService.add(product);
    }

    public void delete(int id) {
        productService.delete(id);
    }

    public void update(int id,Product product) {
        productService.update(id,product);
    }

    public List<Product> getByName(String name) {
        List<Product> products = productService.findByNameProduct(name);
        return products;
    }
    public Product getById(int id) {
        return productService.findById(id);
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            productService.sortByPriceAsc();
        } else {
            productService.sortByPriceDesc();
        }
    }
}
