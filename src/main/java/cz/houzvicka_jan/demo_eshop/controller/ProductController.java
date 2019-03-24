package cz.houzvicka_jan.demo_eshop.controller;

import cz.houzvicka_jan.demo_eshop.dao.ProductRepository;
import cz.houzvicka_jan.demo_eshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController
{
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String showAllProducts(Model model)
    {
        List<Product> list = productRepository.findAll();
        model.addAttribute("products", list);
        return "product-list";
    }

    @GetMapping("/product/detail/{productId}")
    public String showProductById(@PathVariable Integer productId, Model model)
    {
        model.addAttribute("product", productRepository.findById(productId).get());
        return "product-detail";
    }
}
