package org.lessons.java.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Augusto Di Leo");
        return "index";
    }
    
    
}
