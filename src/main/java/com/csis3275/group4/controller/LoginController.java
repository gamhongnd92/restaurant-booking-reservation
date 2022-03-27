package com.csis3275.group4.controller;

import com.csis3275.group4.entity.User;
import com.csis3275.group4.repository.StaffRepository;
import com.csis3275.group4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    private StaffRepository staffRepository;

    public LoginController(UserRepository userRepository, StaffRepository staffRepository){
        this.userRepository = userRepository;
        this.staffRepository = staffRepository;
    }

    @GetMapping("/checkuser/{link}")
    public String checkSessionIsNull(HttpServletRequest request, Model model, @PathVariable("link") String redirectLink){
        Object user = request.getSession().getAttribute("USER_NAME");
        if(user != null){
            if(user.toString().equals("admin")){
                return "manager_dashboard";
            }
            else {
                model.addAttribute("staffList", staffRepository.findAll());
                return  "staff_dashboard";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        Object user = request.getSession().getAttribute("USER_NAME");
        User newUser = new User();
        model.addAttribute("user", newUser);
        if(user != null){
            if(user.toString().equals("admin")){
                return "redirect:/managerdashboard";
            } else {
                return "redirect:/staffdashboard";
            }
        } else {
            return "login_page";
        }
    }

    @PostMapping("/authorise")
    public String authorise(@ModelAttribute User user, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "redirect:/login";
        }
        List<User> userList = userRepository.findAll();

        for(User thisUser : userList){
            if(user.getUserName().equals(thisUser.getUserName()) && user.getPassword().equals(thisUser.getPassword())) {
                request.getSession().setAttribute("USER_NAME", user.getUserName());
                System.out.println(request.getAttribute("USER_NAME"));
                if(user.getUserName().equals("admin")){
                    return "redirect:/managerdashboard";
                } else {
                    return "redirect:/staffdashboard";
                }
            }
        }

        return "login_page";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        //invalidate the session
        request.getSession().invalidate();
        return "redirect:/";
    }
}
