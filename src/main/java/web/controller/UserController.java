package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/new/")
    public String saveUser(Model model) {
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/delete/")
    public String deleteUser(
            @RequestParam(value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "users/one/")
    public String updateUser(
            @RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "saveUser";
    }

    @PostMapping(value = "users/one/edit/")
    public String updateUser(
            @RequestParam(value = "id") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/all/")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
