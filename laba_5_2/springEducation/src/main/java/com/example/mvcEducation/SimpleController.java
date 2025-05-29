package com.example.mvcEducation;

import com.example.springEducation.TextBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Autowired
    TextBook textbook;

    @GetMapping("/simple")
    public String showForm(Model model){
        model.addAttribute("weight", textbook.getWeight());
        model.addAttribute("popularity", textbook.estimatedPopularity());
        return "simple";
    }
}
