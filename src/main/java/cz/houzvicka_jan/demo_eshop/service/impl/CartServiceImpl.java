package cz.houzvicka_jan.demo_eshop.service.impl;

import cz.houzvicka_jan.demo_eshop.service.OrderFormService;
import cz.houzvicka_jan.demo_eshop.entity.OrderForm;
import cz.houzvicka_jan.demo_eshop.entity.OrderState;
import cz.houzvicka_jan.demo_eshop.entity.OrderedProduct;
import cz.houzvicka_jan.demo_eshop.entity.Product;
import cz.houzvicka_jan.demo_eshop.service.CartService;
import cz.houzvicka_jan.demo_eshop.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService
{
    private OrderFormService orderFormService;

    private OrderedProductService orderedProductService;

    private Map<Product, Integer> products = new HashMap<>();

    @Autowired
    public CartServiceImpl(OrderFormService orderFormService, OrderedProductService orderedProductService)
    {
        this.orderFormService = orderFormService;
        this.orderedProductService = orderedProductService;
    }

    @Override
    public void addProduct(Product product)
    {
        if (products.containsKey(product))
        {
            products.replace(product, products.get(product) + 1);
        }
        else
        {
            products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product)
    {
        if (products.containsKey(product))
        {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1)
                products.remove(product);
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart()
    {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public void checkout()
    {
        OrderForm order = new OrderForm();
        order.setOrderState(OrderState.NEW);
        orderFormService.addNewOrder(order);

        List<OrderedProduct> list = new ArrayList<>();

        products.forEach((product, integer) -> {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setAmount(integer);
            orderedProduct.setOrder(order);
            orderedProduct.setProduct(product);

            list.add(orderedProduct);
        });

        orderedProductService.addAll(list);

        products.clear();
    }

    @Override
    public Double getTotal()
    {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue())
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
