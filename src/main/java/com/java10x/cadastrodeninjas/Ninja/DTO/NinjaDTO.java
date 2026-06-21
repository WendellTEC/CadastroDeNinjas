package com.java10x.cadastrodeninjas.Ninja.DTO;

import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String imgUrl;
    private String rank;
    private MissionModel missions;

}
