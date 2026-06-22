package com.java10x.cadastrodeninjas.Ninja.Controller;

import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
import com.java10x.cadastrodeninjas.Ninja.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Add ninja (CREATE)
    @GetMapping("/add")
    public String getFormAddNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "addNinja";
    }

    // Save ninja added
    @PostMapping("/save")
    public String saveNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.addNinja(ninja);
        redirectAttributes.addFlashAttribute("message", "Ninja added!");
        return "redirect:/ninjas/ui/list";
    }

    // Get ninjas (READ)
    @GetMapping("/list")
    public String getNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.getNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjasList.html";
    }

    // Get ninja by id  (READ)
    @GetMapping("/list/{id}")
    public String getNinjaById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "ninjaDetails.html";
        } else {
            model.addAttribute("message", "Ninja not found");
            return "ninjasList.html";
        }
    }

    // Modify ninja data (UPDATE)
    @GetMapping("/modify/{id}")
    public String getFormModifyNinja(@PathVariable Long id, Model model) {
            NinjaDTO ninja = ninjaService.getNinjaById(id);
            model.addAttribute("ninja", ninja);
            return "ninjaModify.html";
    }

    @PutMapping("/save/{id}")
    public String saveNinjaModify(@PathVariable Long id, @ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.modifyNinjaById(id, ninja);
        redirectAttributes.addFlashAttribute("message", "Ninja modified");
        return "redirect:/ninjas/ui/list";
    }

    // Delete ninja (DELETE)
    @GetMapping("/delete/{id}")
    public String deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
        return "redirect:/ninjas/ui/list";
    }

}
