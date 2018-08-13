package com.hibernate.hibernatedemo.controllers;

import com.hibernate.hibernatedemo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/first")
    public String hi(Model model, HttpSession httpSession){
        User u = new User("Pesho", 5);
        //model.addAttribute("pederaz", u);
        model.addAttribute("name1","Motherfucker");
        httpSession.setAttribute("name", "Gosho");
        return "firstView" ;//:: #nasko";
    }

    @GetMapping("/second")
    public ModelAndView mav(){
        User u = new User("Pesho",7);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("second");
        modelAndView.addObject("pederaz", u);
        return modelAndView;
    }

    @GetMapping("")
    public String vuk(){
        return "index";
    }

    @GetMapping("/loop")
    public String cuk(Model model){
        User user1 = new User("Zasko", 10);
        User user2 = new User("Vasko", 11);
        User user3 = new User("Jasko", 12);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (int i = 1; i <100; i++){
            list.add(new User(Integer.toString(i), i + 20));
        }
        model.addAttribute("list", list);
        //return "second :: frag";
        return "loop";
    }
}
