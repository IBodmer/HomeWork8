package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/search")
    public String getUserById(@RequestParam(required = false) Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "search";
    }

    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserSubmit(@PathVariable Long id, @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/";
    }



    @DeleteMapping("/delete/{id}")
    public String deleteUserSubmit(@PathVariable Long id) {
        User byId = userService.findById(id);
        userService.delete(byId);
        return "redirect:/";
    }
}