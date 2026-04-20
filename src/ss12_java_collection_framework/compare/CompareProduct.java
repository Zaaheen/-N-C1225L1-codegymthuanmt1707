package ss12_java_collection_framework.compare;

import ss12_java_collection_framework.entity.Product;

import java.util.Comparator;

public class CompareProduct implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
