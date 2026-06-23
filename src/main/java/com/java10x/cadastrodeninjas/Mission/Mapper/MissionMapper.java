package com.java10x.cadastrodeninjas.Mission.Mapper;

import com.java10x.cadastrodeninjas.Mission.DTO.MissionDTO;
import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionModel map(MissionDTO missionDTO) {

        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDifficulty(missionDTO.getDifficulty());
        missionModel.setNinja(missionDTO.getNinja());

        return missionModel;

    }

    public MissionDTO map(MissionModel missionModel) {

        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDifficulty(missionModel.getDifficulty());
        missionDTO.setNinja(missionModel.getNinja());

        return missionDTO;

    }

}
