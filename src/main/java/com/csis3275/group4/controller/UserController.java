package com.csis3275.group4.controller;

import com.csis3275.group4.entity.User;
import com.csis3275.group4.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {this.userRepository = userRepository;}

    @GetMapping("/users")
    public String showUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user_display";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_create";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()){
            return "user_create";
        }

        userRepository.save(user);

        return "redirect:/users";
    }

	@GetMapping("/changePass/{id}")
    public String editTable(@PathVariable("id") String id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user_update";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") String id, @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            user.setId(id);
            return "user_update";
        }
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }


}
