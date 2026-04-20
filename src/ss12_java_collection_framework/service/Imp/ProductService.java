package ss12_java_collection_framework.service.Imp;

import ss12_java_collection_framework.entity.Product;
import ss12_java_collection_framework.repository.ProductRepository;
import ss12_java_collection_framework.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private static ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id,Product product) {
        productRepository.update(id,product);
    }

    @Override
    public List<Product> findByNameProduct(String name) {
        return productRepository.findByNameProduct(name);
    }

    @Override
    public void sortByPriceAsc() {
        productRepository.sortByPriceAsc();
    }

    @Override
    public void sortByPriceDesc() {
        productRepository.sortByPriceDesc();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }


}
