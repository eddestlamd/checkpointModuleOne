package com.example.checkpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChecklistController {

    @Autowired CheckitemRepository repository;

    @GetMapping("/")
    public String showApp(Model model){
        List<Checkitem> checkList = repository.findAll();
        model.addAttribute("checkList", checkList);
        System.out.println("CHANGE TWWO");
        System.out.println("changes from amanda-1_dev");

        return "checklist";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("checkitem", new Checkitem());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Checkitem checkitem){
        repository.save(checkitem);


        return "redirect:/";
    }


}

