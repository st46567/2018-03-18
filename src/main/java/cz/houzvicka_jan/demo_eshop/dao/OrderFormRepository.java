package cz.houzvicka_jan.demo_eshop.dao;

import cz.houzvicka_jan.demo_eshop.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFormRepository extends JpaRepository<OrderForm, Long>{}
