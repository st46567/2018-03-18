package cz.houzvicka_jan.demo_eshop.service;

import cz.houzvicka_jan.demo_eshop.entity.Product;

import java.util.Map;

public interface CartService
{
    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout();

    Double getTotal();
}
