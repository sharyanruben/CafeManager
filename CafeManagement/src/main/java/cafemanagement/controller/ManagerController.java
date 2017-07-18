package cafemanagement.controller;

import cafemanagement.model.Product;
import cafemanagement.model.Tables;
import cafemanagement.model.User;
import cafemanagement.service.tablesevice.TableService;
import cafemanagement.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/managerPage")
public class ManagerController {

    @Autowired
    private UserService userService;
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/createWaiterPage")
    public String createWaiter(Model model) {
        model.addAttribute("waiter", new User());
        return "manager/create_waiter";
    }

    @RequestMapping(value = "/createTablePage")
    public String createTable(Model model) {
        model.addAttribute("tables", new Tables());
        return "manager/create_table";
    }

    @RequestMapping(value = "/createProductPage")
    public String createProduct(Model model) {
        model.addAttribute("products", new Product());
        return "manager/create_product";
    }

    @RequestMapping(value = "/assignTableToWaiterPage")
    public String assignTableToWaiter(Model model) {
        List<User> waiterList = userService.getAll();
        List<Tables> tablesList = tableService.getAll();
        model.addAttribute("waiterList", waiterList);
        model.addAttribute("tableList", tablesList);
        return "manager/assign_table_to_waiter";
    }


    @RequestMapping(value = "/managerForm")
    public String managerForm(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("userSession") != null) {
            User manager = (User) httpSession.getAttribute("userSession");
            model.addAttribute("manager", manager);
        }
        return "manager/manager";
    }
}
