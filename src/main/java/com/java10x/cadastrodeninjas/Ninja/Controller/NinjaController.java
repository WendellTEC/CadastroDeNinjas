package com.java10x.cadastrodeninjas.Ninja.Controller;

import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
import com.java10x.cadastrodeninjas.Ninja.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Welcome message", description = "This route provides a welcome message to those who access it.")
    public String welcome() {
        return "Hello, welcome to API";
    }

    // Add ninja (CREATE)
    @PostMapping("/add")
    @Operation(summary = "Add New Ninja", description = "This route creates a new ninja and inserts it into the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja created"),
            @ApiResponse(responseCode = "400", description = "Error in ninja creation")
    })
    public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.addNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja created: " + newNinja.getName() + " (ID): " + newNinja.getId());

    }

    // Get ninjas (READ)
    @GetMapping("/list")
    @Operation(summary = "List all ninjas", description = "This route List for the user all ninjas registered in the database.")
    public ResponseEntity<List<NinjaDTO>> getNinjas() {
        List<NinjaDTO> ninjas = ninjaService.getNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Get ninja by id  (READ)
    @GetMapping("/list/{id}")
    @Operation(summary = "List the ninja with ID", description = "This route List for the user the ninja with the request id and return the ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja found"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> getNinjaById(
            @Parameter(description = "The user sends the ID in the request path")
            @PathVariable Long id) {

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
    @Operation(summary = "Modifies ninja information", description = "This route allows the user to modify the information of a ninja present in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Updated"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<?> modifyNinjaById(
            @Parameter(description = "The user sends the ID in the request path")
            @PathVariable Long id,
            @Parameter(description = "The user sends the ninja's data in the body of the request ")
            @RequestBody NinjaDTO ninjaUpdated) {

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
    @Operation(summary = "Delete a ninja of database", description = "This route allows the user to delete a ninja from the database.")
    public ResponseEntity<?> deleteNinjaById(
            @Parameter(description = "The user sends the ID in the request path")
            @PathVariable Long id) {

        if (ninjaService.getNinjaById(id) != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja Deleted, ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found!");
        }
    }

}
