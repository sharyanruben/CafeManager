package cafemanagement.controller;

import cafemanagement.model.Order;
import cafemanagement.model.Tables;
import cafemanagement.model.enums.OrderStatus;
import cafemanagement.service.orderservice.OrderService;
import cafemanagement.service.tablesevice.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private TableService tableService;
    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/createOrders/{tableId}")
    public String createOrder(@PathVariable(value = "tableId") int id, Model model) {
        Tables table = tableService.getById(id);
        if (table != null) {
            Order order = new Order();
            order.setTable(table);
            order.setOrderStatus(OrderStatus.OPEN);
            orderService.create(order);
            model.addAttribute("message", "order created success");
            return "forward:/waiter/waiterPage";
        }
        model.addAttribute("message", "order's create is failed");
        return "forward:/waiter/waiterPage";
    }

    @RequestMapping(value = "/showOrders/{tableId}")
    public String showOrder(@PathVariable(value = "tableId") int id, Model model) {
        Tables table = tableService.getById(id);
        if (table != null) {
            model.addAttribute("table", table);
            model.addAttribute("orderList", table.getOrderList());
            return "waiter/table_order";
        }
        model.addAttribute("message", "you can't see orders");
        return "forward:/waiter/waiterPage";
    }

    @RequestMapping(value = "/closeOrder/{orderId}")
    public String closeOrder(@PathVariable(value = "orderId") int orderId, Model model) {
        Order order = orderService.getById(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CLOSED);
            orderService.update(order);
            int tableId = order.getTable().getTableId();
            model.addAttribute("message", "oreder is close");
            return "forward:/order/showOrders/" + tableId;
        }
        model.addAttribute("message", "order is not closed");
        return "forward:/waiter/waiterPage";
    }

    @RequestMapping(value = "/cancelOrder/{orderId}")
    public String cancelOrder(@PathVariable(value = "orderId") int orderId, Model model) {
        Order order = orderService.getById(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            int tableId = order.getTable().getTableId();
            orderService.update(order);
            model.addAttribute("message", "oreder is cancel");
            return "forward:/order/showOrders/" + tableId;
        }
        model.addAttribute("message", "order is not canseled");
        return "forward:/waiter/waiterPage";
    }

    @RequestMapping(value = "/orderDetails/{orderId}")
    public String orderDetails(@PathVariable(value = "orderId") int id, Model model) {
        Order order = orderService.getById(id);
        if (order != null) {
            model.addAttribute("productInOrderList", order.getProductInOrderList());
            model.addAttribute("order", order);
            return "waiter/show_order_details";
        }
        model.addAttribute("message", "you can't see show order details");
        return "forward:/waiter/waiterPage";
    }
}
