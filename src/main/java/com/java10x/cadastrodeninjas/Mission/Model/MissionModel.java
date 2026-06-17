package com.java10x.cadastrodeninjas.Mission.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;

}
