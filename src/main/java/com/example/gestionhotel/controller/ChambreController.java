package com.example.gestionhotel.controller;

import com.example.gestionhotel.model.Chambre;
import com.example.gestionhotel.model.Etatchambre;
import com.example.gestionhotel.model.Typechambre;
import com.example.gestionhotel.repository.ChambreRepository;
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
public class ChambreController {
    private final ChambreRepository chambreRepository;


    public ChambreController(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @GetMapping("/chambre")
    public String indexchambre(Model model){
        model.addAttribute("chambres", chambreRepository.findAll());
        return "indexchambre";
    }

    @GetMapping("/chambre/chambre/new")
    public String newChambre(Model model){
        model.addAttribute("chambre", new Chambre());
        model.addAttribute("types", Typechambre.values());
        model.addAttribute("etats", Etatchambre.values());
        return "newChambre";
    }

    @PostMapping("/chambre/chambre")
    public String saveChambre(@Valid @ModelAttribute("chambre") Chambre chambre, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("types", Typechambre.values());
            model.addAttribute("etats", Etatchambre.values());
            return "newChambre";
        }
        chambreRepository.save(chambre);
        return "redirect:/chambre";
    }

    @GetMapping("/chambre/chambre/edit/{idchambre}")
    public  String editChambre(@PathVariable Long idchambre, Model model){
        Chambre chambre = chambreRepository.findById(idchambre).orElseThrow(() -> new IllegalArgumentException("Invalid chambre id:" +idchambre));
        model.addAttribute("chambre", chambre);
        model.addAttribute("types", Typechambre.values());
        model.addAttribute("etats", Etatchambre.values());
        return "editChambre";
    }

    @PostMapping("/chambre/chambre/{idchambre}")
    public String updateChambre(@PathVariable Long idchambre, @Valid @ModelAttribute("chambre") Chambre chambre,BindingResult bindingResult, Model model ){
        if(bindingResult.hasErrors()){
            model.addAttribute("types", Typechambre.values());
            model.addAttribute("etats", Etatchambre.values());
            return "editChambre";
        }
        chambreRepository.save(chambre);
        return "redirect:/chambre";
    }

    @GetMapping("/chambre/chambre/delete/{idchambre}")
    public String deleteChambre(@PathVariable Long idchambre, Model model){
        chambreRepository.deleteById(idchambre);
        return "redirect:/chambre";
    }
}
