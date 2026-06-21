package com.java10x.cadastrodeninjas.Ninja.Controller;

import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
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
    public NinjaDTO addNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.addNinja(ninja);
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
    @PutMapping("/modify/{id}")
    public NinjaModel modifyNinjaById(@PathVariable Long id, @RequestBody NinjaModel ninjaUpdated) {
        return ninjaService.modifyNinjaById(id, ninjaUpdated);
    }

    // Delete ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public String deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
        return "The ninja was deleted!";
    }

}
