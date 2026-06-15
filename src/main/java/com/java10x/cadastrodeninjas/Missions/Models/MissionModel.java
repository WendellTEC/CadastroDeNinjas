package com.java10x.cadastrodeninjas.Missions.Models;

import com.java10x.cadastrodeninjas.Ninjas.Models.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String difficulty;

    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

}
