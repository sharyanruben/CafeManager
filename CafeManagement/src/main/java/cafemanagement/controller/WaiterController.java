package cafemanagement.controller;

import cafemanagement.model.User;
import cafemanagement.model.enums.Role;
import cafemanagement.service.userservice.UserService;
import cafemanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private Validator validator;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addwaiter", method = RequestMethod.POST)
    public String addWaiter(@ModelAttribute(value = "waiter") @Valid User user,
                            Model model) {
        if (validator.isEmpty(user.getUsername())) {
            model.addAttribute("message", "waiter's name is required, place input waiter name");
            return "forward:/managerPage/createWaiterPage";
        }
        if (validator.isEmpty(user.getPassword())) {
            model.addAttribute("message", "waiter's password is required, place input password");
            return "forward:/managerPage/createWaiterPage";
        }
        if (validator.isUserExist(user.getUsername())) {
            model.addAttribute("message", "waiter's username is exist, place input another username");
            return "forward:/managerPage/createWaiterPage";
        }
        user.setRole(Role.WAITER);
        userService.create(user);
        model.addAttribute("message", "creating waiter is success");
        return "forward:/managerPage/createWaiterPage";
    }

    @RequestMapping(value = "/waiterPage")
    public String waiterForm(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("userSession") != null) {
            User waiter = (User) httpSession.getAttribute("userSession");
            model.addAttribute("tableList", waiter.getTableList());
            model.addAttribute("waiter", waiter);
        }
        return "waiter/waiter";
    }
}
