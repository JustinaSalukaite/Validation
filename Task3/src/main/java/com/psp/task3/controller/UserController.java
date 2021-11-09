package com.psp.task3.controller;

import com.psp.task3.exception.InvalidUserException;
import com.psp.task3.model.User;
import com.psp.task3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-user")
    public String showAll(ModelMap model) {
        model.put("users", userService.findAll());
        return "list-user";
    }

    @GetMapping("/add-user")
    public String showAddActionPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "add-user";
    }


    @PostMapping("/add-user")
    public String add(ModelMap model, @ModelAttribute("user") User user, BindingResult result) {

        if(result.hasErrors()) {
            return "add-user";
        }
        try {
            user = userService.addUser(user);
        } catch (InvalidUserException e) {
            model.addAttribute("validationError", e.getMessage());
            return "error-user";
        }

        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/delete-user/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/list-user";
    }


    @GetMapping("/update-user/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable int id) {
        model.addAttribute("user", userService.findById(id));
        return "add-user";
    }

    @PostMapping("/update-user/{id}")
    public String update(ModelMap model, @ModelAttribute("user") User user, @PathVariable int id,
                         BindingResult result) {
        if(result.hasErrors()) {
            return "add-user";
        }

        try {
            userService.updateUser(id, user);
        } catch (InvalidUserException e) {
            return "error-user";
        }
        return "redirect:/list-user";
    }


    @GetMapping("/user/{id}")
    public String showUser(ModelMap model, @ModelAttribute("users") User user, @PathVariable int id, BindingResult result) {

        if(result.hasErrors()) {
            return "list-user";
        }

        User userFound = userService.findById(id);
        List<User> userList = new ArrayList<>();
        userList.add(userFound);
        model.put("users", userList);
        return "list-user";
    }


}
