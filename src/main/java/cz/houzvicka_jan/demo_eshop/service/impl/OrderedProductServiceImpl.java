package cz.houzvicka_jan.demo_eshop.service.impl;

import cz.houzvicka_jan.demo_eshop.dao.OrderedProductRepository;
import cz.houzvicka_jan.demo_eshop.entity.OrderedProduct;
import cz.houzvicka_jan.demo_eshop.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductServiceImpl implements OrderedProductService
{
    private OrderedProductRepository orderedProductRepository;

    @Autowired
    public OrderedProductServiceImpl(OrderedProductRepository orderedProductRepository)
    {
        this.orderedProductRepository = orderedProductRepository;
    }

    public void addAll(List<OrderedProduct> orderedProductList)
    {
        orderedProductRepository.saveAll(orderedProductList);
    }
}
