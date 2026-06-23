package com.java10x.cadastrodeninjas.Ninja.Service;

import com.java10x.cadastrodeninjas.Mission.Mapper.MissionMapper;
import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import com.java10x.cadastrodeninjas.Mission.Repository.MissionRepository;
import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
import com.java10x.cadastrodeninjas.Ninja.Mapper.NinjaMapper;
import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import com.java10x.cadastrodeninjas.Ninja.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;
    private final MissionRepository missionRepository;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissionRepository missionRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missionRepository = missionRepository;
    }

    // Add ninja
    public NinjaDTO addNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Get ninjas
    public List<NinjaDTO> getNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Get ninja by id
    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    // Modify ninja
    public NinjaDTO modifyNinjaById(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExists = ninjaRepository.findById(id);
        if (ninjaExists.isPresent()) {
            NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
            ninjaUpdated.setId(id);
            NinjaModel ninjaSaved = ninjaRepository.save(ninjaUpdated);
            return ninjaMapper.map(ninjaSaved);
        }
        return null;

    }

    // Delete ninja by id
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

    public void assignMission(Long ninjaId, Long missionId) {

        NinjaModel ninja = ninjaRepository.findById(ninjaId)
                .orElseThrow(() -> new RuntimeException("Ninja not found"));

        MissionModel mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        ninja.setMissions(mission);

        ninjaRepository.save(ninja);
    }

}
