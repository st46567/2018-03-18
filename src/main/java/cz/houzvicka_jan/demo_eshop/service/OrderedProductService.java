package cz.houzvicka_jan.demo_eshop.service;

import cz.houzvicka_jan.demo_eshop.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductService
{
    void addAll(List<OrderedProduct> orderedProductList);
}
