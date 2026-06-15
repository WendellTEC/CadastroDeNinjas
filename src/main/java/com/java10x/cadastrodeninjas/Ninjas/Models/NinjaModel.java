package com.java10x.cadastrodeninjas.Ninjas.Models;

import com.java10x.cadastrodeninjas.Missions.Models.MissionModel;
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
@Table(name = "tb_register")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer age;

    @ManyToOne()
    @JoinColumn(name = "missions_id")
    private MissionModel missions;


}
