package test.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.library.entities.User;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String submitLogin() {
        return "all_books";
    }

    @GetMapping("/access_error")
    public String error403() {
        return "error_403";
    }
}
