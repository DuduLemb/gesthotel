package com.example.gestionhotel.controller;

import com.example.gestionhotel.model.Employe;
import com.example.gestionhotel.model.Posteemploye;
import com.example.gestionhotel.repository.EmployeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeController {

    private final EmployeRepository employeRepository;

    public EmployeController(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employes", employeRepository.findAll());
        return "index";
    }

    @GetMapping("/employe/new")
    public String newEmploye(Model model){
        model.addAttribute("employe", new Employe());
        model.addAttribute("types", Posteemploye.values());
        return "newEmploye";
    }
    @PostMapping("/employe")
    public String saveEmploye(@Valid @ModelAttribute("employe") Employe employe, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("types", Posteemploye.values());
            return "newEmploye";
        }
        employeRepository.save(employe);
        return "redirect:/";
    }

    @GetMapping("/employe/edit/{idemploye}")
    public  String editEmploye(@PathVariable Long idemploye, Model model){
        Employe employe = employeRepository.findById(idemploye).orElseThrow(() -> new IllegalArgumentException("Invalid employe id:" +idemploye));
        model.addAttribute("employe", employe);
        model.addAttribute("types", Posteemploye.values());
        return  "editEmploye";
    }

    @PostMapping("/employe/{idemploye}")
    public  String updateEmploye(@PathVariable Long idemploye, @Valid @ModelAttribute("employe") Employe employe, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("types", Posteemploye.values());
            return "editEmploye";
        }
        employeRepository.save(employe);
        return "redirect:/";
    }

    @GetMapping("/employe/delete/{idemploye}")
    public String deleteEmploye(@PathVariable Long idemploye, Model model){
        employeRepository.deleteById(idemploye);
        return "redirect:/";
    }

}
