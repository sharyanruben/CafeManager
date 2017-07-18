package cafemanagement.controller;

import cafemanagement.model.User;
import cafemanagement.model.enums.Role;
import cafemanagement.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String userName,
                        @RequestParam(name = "password") String password,
                        HttpSession httpSession, Model model) {

        User user = userService.getUserByUserNamePassword(userName, password);
        if (user != null) {
            model.addAttribute("user", user);
            httpSession.setAttribute("userSession", user);
            if (user.getRole() == Role.MANAGER) {
                return "redirect:/managerPage/managerForm";
            } else {
                return "redirect:/waiter/waiterPage";
            }
        }
        model.addAttribute("message", "Username or Password is Invalid");
        return "forward:/loginForm";
    }

    @RequestMapping(value = "/loginForm")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession httpSession) {
        httpSession.removeAttribute("userSession");
        return "redirect:/loginForm";
    }
}
