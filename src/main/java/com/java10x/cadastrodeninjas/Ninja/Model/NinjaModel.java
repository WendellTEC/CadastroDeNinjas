package com.java10x.cadastrodeninjas.Ninja.Model;

import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_register")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "age")
    private Integer age;

    @ManyToOne()
    @JoinColumn(name = "missions_id")
    private MissionModel missions;


}
