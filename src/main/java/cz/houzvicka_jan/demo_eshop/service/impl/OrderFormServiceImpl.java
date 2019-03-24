package cz.houzvicka_jan.demo_eshop.service.impl;

import cz.houzvicka_jan.demo_eshop.service.OrderFormService;
import cz.houzvicka_jan.demo_eshop.dao.OrderFormRepository;
import cz.houzvicka_jan.demo_eshop.entity.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFormServiceImpl implements OrderFormService
{
    private OrderFormRepository orderFormRepository;

    @Autowired
    public OrderFormServiceImpl(OrderFormRepository orderFormRepository)
    {
        this.orderFormRepository = orderFormRepository;
    }

    public void addNewOrder(OrderForm orderForm)
    {
        orderFormRepository.saveAndFlush(orderForm);
    }
}
