package com.java10x.cadastrodeninjas.Mission.DTO;

import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {

    private Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> ninja;

}
