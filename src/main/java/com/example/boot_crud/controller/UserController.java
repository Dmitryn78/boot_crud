package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public  String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUserById(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/";

    }
}
