package cz.houzvicka_jan.demo_eshop.controller;

import cz.houzvicka_jan.demo_eshop.service.CartService;
import cz.houzvicka_jan.demo_eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController
{
    private CartService cartService;

    private ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService)
    {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String showCart(Model model)
    {
        model.addAttribute("products", cartService.getProductsInCart());
        model.addAttribute("total", cartService.getTotal());

        return "cart";
    }

    @GetMapping("/cart/addProduct/{productId}")
    public String addToCart(@PathVariable Integer productId, Model model)
    {
        productService.findById(productId).ifPresent(cartService::addProduct);

        return showCart(model);
    }

    @GetMapping("/cart/removeProduct/{productId}")
    public String removeFromCart(@PathVariable Integer productId, Model model)
    {
        productService.findById(productId).ifPresent(cartService::removeProduct);

        return showCart(model);
    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model)
    {
        cartService.checkout();

        return showCart(model);
    }
}
