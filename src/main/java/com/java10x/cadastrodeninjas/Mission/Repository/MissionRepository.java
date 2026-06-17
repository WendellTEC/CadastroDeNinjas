package com.java10x.cadastrodeninjas.Mission.Repository;

import com.java10x.cadastrodeninjas.Mission.Model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionModel, Long> {
}
