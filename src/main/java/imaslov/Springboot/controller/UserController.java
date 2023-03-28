package imaslov.Springboot.controller;

import imaslov.Springboot.model.User;
import imaslov.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "showAllUsers";
    }
    @GetMapping("/{id}")
    public String readUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.readUser(id));
        return "showUser";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.readUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
