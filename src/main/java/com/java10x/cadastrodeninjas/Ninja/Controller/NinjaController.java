package com.java10x.cadastrodeninjas.Ninja.Controller;

import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import com.java10x.cadastrodeninjas.Ninja.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, welcome to API";
    }

    // Add ninja (CREATE)
    @PostMapping("/add")
    public String addNinja() {
        return "ninja added";
    }

    // Get ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> getNinjas() {
        return ninjaService.getNinjas();
    }

    // Get ninja by id  (READ)
    @GetMapping("/list/{id}")
    public NinjaModel getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Modify ninja data (UPDATE)
    @PutMapping("/modifyID")
    public String modifyNinjaById() {
        return "Ninja modified";
    }

    // Delete ninja (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteNinjaById() {
        return "Ninja deleted";
    }

}
