package cafemanagement.controller;

import cafemanagement.model.Tables;
import cafemanagement.model.User;
import cafemanagement.service.tablesevice.TableService;
import cafemanagement.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/assign")
public class AssignTableToWaiter {

    @Autowired
    private UserService userService;
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/assignTableToWaiter", method = RequestMethod.GET)
    public String assignTableToWaiter(@RequestParam(name = "waiterId") int waiterId,
                                      @RequestParam(name = "tableId") int tableId,
                                      Model model) {

        User waiter = userService.getById(waiterId);
        Tables table = tableService.getById(tableId);
        if (waiter != null && table != null) {
            table.setUser(waiter);
            table.setTableStatus(0);
            tableService.update(table);
            model.addAttribute("message", "table is success assign to waiter");
            return "forward:/managerPage/assignTableToWaiterPage";
        }
        model.addAttribute("message", "table isn't assign to waiter");
        return "redirect:/managerPage/assignTableToWaiterPage";
    }

}
