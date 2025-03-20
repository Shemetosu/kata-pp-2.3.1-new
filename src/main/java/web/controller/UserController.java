package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService carService;

    public UserController(UserService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(
            @RequestParam(value = "count", defaultValue = "5") int count,
            Model model) {
        List<User> cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "users";
    }
}
