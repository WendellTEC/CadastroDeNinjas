package com.java10x.cadastrodeninjas.Mission.Controller;

import com.java10x.cadastrodeninjas.Mission.DTO.MissionDTO;
import com.java10x.cadastrodeninjas.Mission.Service.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    // Add Missions (CREATE)
    @PostMapping("/add")
    public ResponseEntity<String> addMission(@RequestBody MissionDTO mission) {
        MissionDTO newMission = missionService.addMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission created: " + newMission.getName() + " (ID): " + newMission.getId());
    }

    // Get Missions (READ)
    @GetMapping("/list")
    public ResponseEntity<List<MissionDTO>> getMissions() {
        List<MissionDTO> missions = missionService.getMissions();
        return ResponseEntity.ok(missions);
    }

    // Get Mission by id (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> getMissionById(@PathVariable Long id) {
        MissionDTO missionById = missionService.getMissionById(id);
        if (missionById != null) {
            return ResponseEntity.ok(missionById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission not found!");
        }
    }

    // Modify Missions (UPDATE)
    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyMissionById(@PathVariable Long id, @RequestBody MissionDTO missionUpdated) {
        MissionDTO missionModify = missionService.modifyMissionById(id, missionUpdated);

        if (missionModify != null) {
            return ResponseEntity.ok(missionModify);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission not found!");
        }
    }

    // Delete Missions (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMissionById(@PathVariable Long id) {

        if (missionService.getMissionById(id) != null) {
            missionService.deleteMissionById(id);
            return ResponseEntity.ok("Mission Deleted, ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission not found!");
        }
    }

}
