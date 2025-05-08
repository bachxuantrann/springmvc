package com.java_spring.springmvc.controller;


import com.java_spring.springmvc.domain.User;
import com.java_spring.springmvc.service.UserService.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUsersByEmail("bxt203@gmail.com");
        System.out.println(arrUsers);
        String content = this.userService.handleHello();
        model.addAttribute("content", content);
        model.addAttribute("usename", "bachxuantran");
        model.addAttribute("password", "123456");
        return "hello";
    }

    //  Get list users
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        System.out.println(users);
        return "admin/user/table-user";
    }

    // Get detail user
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    // Create new user [get]
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    //  Create new user [post]
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPAge(Model model, @ModelAttribute("newUser") User user) {
        System.out.println("Run create user page" + user);
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    // Update user [get]
    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
    public String getUpdateUserPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    // Update user [post]
    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.POST)
    public String updateUserPage(Model model, @PathVariable Long id, @ModelAttribute("user") User user) {
        User newUser = this.userService.updateUser(id, user);
        model.addAttribute("user", newUser);
        return "redirect:/admin/user/{id}";
    }

    // Delete user by ID
    @RequestMapping(value = "/admin/user/delete/{id}", method = RequestMethod.POST)
    public String deleteUserPage(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/user";
    }
}
