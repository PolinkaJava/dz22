package by.teachmeskills.polinka.repository;

import by.teachmeskills.polinka.entity.Product;
import by.teachmeskills.polinka.repository.exeption.ProductNotFound;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository implements ProductRepositoryInter {

    private final String filename = "C:\\Users\\user\\Desktop\\Maven\\project2\\src\\main\\resources\\Products";
    private List<Product> products;

    public ProductRepository() {
        products = deserializeProduct();
    }

    @Override
    public void add(Product product) {
        products.add(product);

        serealizeProduct();
    }


    @Override
    public void deleteProductById(long productId) {
        products.removeIf(product -> product.getId().equals(productId));
        serealizeProduct();
    }
    @Override
    public List<Product> allProducts() {
        return products;
    }

    public long productsIdGenerator() {
        return products.size() + 1;
    }
    public Product findProduct(long idProduct){
        for (Product product : products){
            if (product.getId().equals(idProduct) ) {
                return product;
            }
        }
        throw new ProductNotFound(idProduct);
    }

    public boolean isInStock(long idProduct) {
        Product product = findProduct(idProduct);
        return product!= null && product.getQuantity() > 0;
    }

    private void serealizeProduct() {
        try {

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(products);

            out.close();
            file.close();

            System.out.println("Продукты были сериализованы");
        } catch (IOException ex) {
            throw new RuntimeException("Продукты не сериализовались", ex);
        }

    }

    private List<Product> deserializeProduct() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Product> deserUsers = (List<Product>) ois.readObject();
            return deserUsers;


        } catch (IOException | ClassNotFoundException e) {

        }
        return new ArrayList<>();
    }

}