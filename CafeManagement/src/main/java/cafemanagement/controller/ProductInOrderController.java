package cafemanagement.controller;

import cafemanagement.model.Order;
import cafemanagement.model.Product;
import cafemanagement.model.ProductInOrder;
import cafemanagement.model.enums.OrderStatus;
import cafemanagement.model.enums.ProductInOrderStatus;
import cafemanagement.service.orderservice.OrderService;
import cafemanagement.service.productinordersevice.ProductInOrderService;
import cafemanagement.service.productservice.ProductService;
import cafemanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/productInOrder")
public class ProductInOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private Validator validator;
    @Autowired
    private ProductInOrderService productInOrderService;

    @RequestMapping(value = "/openProductInOrder/{tableId}/{orderId}")
    public String openProductInOrder(@PathVariable(value = "tableId") int tableId,
                                     @PathVariable(value = "orderId") int orderId,
                                     Model model) {
        Order order = orderService.getById(orderId);
        if (order != null && order.getOrderStatus() == OrderStatus.OPEN) {
            List<Product> productList = productService.getAll();
            model.addAttribute("productList", productList);
            model.addAttribute("order", order);
            return "waiter/product_in_order_page";
        }
        model.addAttribute("message", "product status closed or canceled, you can't add any product");
        return "forward:/order/showOrders/" + tableId;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProductInToOrder(@RequestParam("productId") int productId, @RequestParam("orderId") int orderId,
                                      @RequestParam("amount") @Valid int amount, Model model) {

        Order order = orderService.getById(orderId);
        Product product = productService.getById(productId);
        int tableId = order.getTable().getTableId();

        if (validator.isNegativeInteger(amount)) {
            model.addAttribute("message", "place input positive amount");
            return "forward:/productInOrder/openProductInOrder/" + tableId + "/" + orderId;
        }
        if (product != null && order != null) {
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.setProduct(product);
            productInOrder.setProductInOrderStatus(ProductInOrderStatus.ACTIVE);
            productInOrder.setOrderAmount(amount);
            productInOrder.setProductOrder(order);
            try {
                productInOrderService.create(productInOrder);
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("message", "product is already exist this list");
                return "forward:/productInOrder/openProductInOrder/" + tableId + "/" + orderId;
            }
            model.addAttribute("message", "product added in order List successfully");
            return "forward:/productInOrder/openProductInOrder/" + tableId + "/" + orderId;
        }
        model.addAttribute("message", "product isn't added in order's list");
        return "forward:/productInOrder/openProductInOrder/" + tableId + "/" + orderId;
    }

}
