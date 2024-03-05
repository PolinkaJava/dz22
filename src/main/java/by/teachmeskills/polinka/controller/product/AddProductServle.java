package by.teachmeskills.polinka.controller.product;

import by.teachmeskills.polinka.entity.Product;
import by.teachmeskills.polinka.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductServle extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productRepository = new ProductRepository();
        getServletContext().setAttribute("ProductRepository", productRepository);

        long id  = Long.parseLong(req.getParameter("id"));
        long code = Long.parseLong(req.getParameter("code"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        long quantity = Long.parseLong(req.getParameter("quantity"));


        Product product = new Product(id, code, name, price, quantity);


        productRepository.add(product);
        System.out.println("Продукт есть ");

    }
}
