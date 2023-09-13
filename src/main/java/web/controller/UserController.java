package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById((long) id));

        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user){
        userService.updateUser(user);

        return "redirect:users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser((long) id);

        return "redirect:users";
    }



}