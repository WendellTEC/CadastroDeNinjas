package com.java10x.cadastrodeninjas.Mission.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
public class MissionController {

    // Add Missions (CREATE)
    @PostMapping("/add")
    public String addMission() {
        return "Mission added";
    }

    // Get Missions (READ)
    @GetMapping("/list")
    public String getMissions() {
        return "Get all missions";
    }

    // Modify Missions (UPDATE)
    @PutMapping("/modifyID")
    public String modifyMissionById() {
        return "Mission modified";
    }

    // Delete Missions (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteMissionById() {
        return "Mission Deleted";
    }

}
