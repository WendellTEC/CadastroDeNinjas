package com.java10x.cadastrodeninjas.Ninja.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

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
    public String getNinjas() {
        return "Get all Ninjas";
    }

    // Get ninja by id  (READ)
    @GetMapping("/searchID")
    public String getNinjaById() {
        return "Get ninja with ID";
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
