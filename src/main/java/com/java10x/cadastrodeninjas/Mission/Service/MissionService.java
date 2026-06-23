package com.java10x.cadastrodeninjas.Mission.Service;

import com.java10x.cadastrodeninjas.Mission.DTO.MissionDTO;
import com.java10x.cadastrodeninjas.Mission.Mapper.MissionMapper;
import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import com.java10x.cadastrodeninjas.Mission.Repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    // Add Missions (CREATE)
    public MissionDTO addMission(MissionDTO missionDTO) {
        MissionModel mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);
        return missionMapper.map(mission);
    }

    public List<MissionDTO> getMissions() {
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionDTO getMissionById(Long id) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        return missionById.map(missionMapper::map).orElse(null);
    }

    public MissionDTO modifyMissionById(Long id, MissionDTO missionDTO) {
        Optional<MissionModel> missionExists = missionRepository.findById(id);
        if (missionExists.isPresent()) {
            MissionModel missionUodated = missionMapper.map(missionDTO);
            missionUodated.setId(id);
            MissionModel missionSaved = missionRepository.save(missionUodated);
            return missionMapper.map(missionSaved);
        }
        return null;
    }

    public void deleteMissionById(Long id) {
        missionRepository.deleteById(id);
    }


}
