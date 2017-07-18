package cafemanagement.controller;

import cafemanagement.model.Product;
import cafemanagement.service.productservice.ProductService;
import cafemanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Validator validator;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute(value = "products") @Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "manager/create_product";
        }
        if (validator.isNegativeDouble(product.getPrice())) {
            model.addAttribute("message", "place input positive price");
            return "manager/create_product";
        }

        productService.create(product);
        model.addAttribute("message", "create product is success");
        return "forward:/managerPage/createProductPage";
    }

}
