package com.java10x.cadastrodeninjas.Mission.Controller;

import com.java10x.cadastrodeninjas.Mission.DTO.MissionDTO;
import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import com.java10x.cadastrodeninjas.Mission.Service.MissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missions/ui")
public class MissionControllerUi {

    private final MissionService missionService;

    public MissionControllerUi(MissionService missionService) {
        this.missionService = missionService;
    }

    // Add Mission (Create)
    @GetMapping("/add")
    public String getFormAddMission(Model model) {
        model.addAttribute("mission", new MissionDTO());
        return "addMission";
    }

    // Save Ninja added
    @PostMapping("/save")
    public String saveMission(@ModelAttribute MissionDTO mission, RedirectAttributes redirectAttributes) {
        missionService.addMission(mission);
        redirectAttributes.addFlashAttribute("message", "Mission added!");
        return "redirect:/missions/ui/list";
    }

    // Get missions (Read)
    @GetMapping("/list")
    public String getMissions(Model model) {
        List<MissionDTO> missions = missionService.getMissions();
        model.addAttribute("missions", missions);
        return "missionList.html";
    }

    // Get mission by id
    @GetMapping("/list/{id}")
    public String getMissionById(@PathVariable Long id, Model model) {
        MissionDTO mission = missionService.getMissionById(id);
        if (mission != null) {
            model.addAttribute("mission", mission);
            return "missionDetails.html";
        } else {
            model.addAttribute("message", "Mission not found!");
            return "missionList.html";
        }
    }

    // Modify mission data (Update)
    @GetMapping("/modify/{id}")
    public String getFormModifyMission(@PathVariable Long id, Model model) {
        MissionDTO mission = missionService.getMissionById(id);
        model.addAttribute("mission", mission);
        return "missionModify.html";
    }

    @PutMapping("/save/{id}")
    public String saveModifyMission(@PathVariable Long id, @ModelAttribute MissionDTO mission, RedirectAttributes redirectAttributes) {
        missionService.modifyMissionById(id, mission);
        redirectAttributes.addFlashAttribute("message", "Mission modified");
        return "redirect:/missions/ui/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
        return "redirect:/missions/ui/list";
    }

}