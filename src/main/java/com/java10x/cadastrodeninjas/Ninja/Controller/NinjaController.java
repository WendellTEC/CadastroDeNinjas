package com.java10x.cadastrodeninjas.Ninja.Controller;

import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
import com.java10x.cadastrodeninjas.Ninja.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, welcome to API";
    }

    // Add ninja (CREATE)
    @PostMapping("/add")
    public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.addNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created: " + newNinja.getName() + " (ID): " + newNinja.getId());

    }

    // Get ninjas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> getNinjas() {
        List<NinjaDTO> ninjas = ninjaService.getNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Get ninja by id  (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> getNinjaById(@PathVariable Long id) {

        NinjaDTO ninjaById = ninjaService.getNinjaById(id);
        if (ninjaById != null) {
            return ResponseEntity.ok(ninjaById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found!");
        }
    }

    // Modify ninja data (UPDATE)
    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyNinjaById(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated) {

        NinjaDTO ninjaModify = ninjaService.modifyNinjaById(id, ninjaUpdated);

        if (ninjaModify != null) {
            return ResponseEntity.ok(ninjaModify);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found!");
        }

    }

    // Delete ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNinjaById(@PathVariable Long id) {

        if (ninjaService.getNinjaById(id) != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja Deleted, ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found!");
        }
    }

}
