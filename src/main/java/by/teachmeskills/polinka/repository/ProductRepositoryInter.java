package by.teachmeskills.polinka.repository;

import by.teachmeskills.polinka.entity.Product;

import java.util.Collection;

public interface ProductRepositoryInter {
    public void add(Product product);
    public void  deleteProductById(long productId);
    public Collection<Product> allProducts();
}
