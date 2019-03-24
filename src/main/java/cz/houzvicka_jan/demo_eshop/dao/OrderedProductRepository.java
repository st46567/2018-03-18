package cz.houzvicka_jan.demo_eshop.dao;

import cz.houzvicka_jan.demo_eshop.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long>{}
