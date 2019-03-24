package cz.houzvicka_jan.demo_eshop.service;

import cz.houzvicka_jan.demo_eshop.entity.Product;

import java.util.Optional;

public interface ProductService
{
    Optional<Product> findById(Integer id);
}
