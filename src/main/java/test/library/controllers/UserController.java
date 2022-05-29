package test.library.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.library.entities.User;
import test.library.services.UserService;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private UserService dao;

    @RequestMapping("/all_users")
    public String listUser(Model model) {
        List<User> listUsers = dao.findAllUsers();
        model.addAttribute("users", listUsers);
        return "users";
    }
}
