package com.hibernate.hibernatedemo.controllers;

import com.hibernate.hibernatedemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping("/first")
    public String hi(Model model, HttpSession httpSession){
        User u = new User("Pesho");
        model.addAttribute("pederaz", u);
        //model.addAttribute("name","Motherfucker");
        httpSession.setAttribute("name", "Gosho");
        return "firstView";
    }

    @GetMapping("/second")
    public ModelAndView mav(){
        User u = new User("Pesho");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        modelAndView.addObject("pederaz", u);
        return modelAndView;
    }
}
