package com.java10x.cadastrodeninjas.Ninja.Service;

import com.java10x.cadastrodeninjas.Ninja.DTO.NinjaDTO;
import com.java10x.cadastrodeninjas.Ninja.Mapper.NinjaMapper;
import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import com.java10x.cadastrodeninjas.Ninja.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Add ninja
    public NinjaDTO addNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Get ninjas
    public List<NinjaModel> getNinjas() {
        return ninjaRepository.findAll();
    }

    // Get ninja by id
    public NinjaModel getNinjaById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    // Modify ninja
    public NinjaModel modifyNinjaById(Long id, NinjaModel ninjaUpdated) {
        if (ninjaRepository.existsById(id)) {
            ninjaUpdated.setId(id);
            return ninjaRepository.save(ninjaUpdated);
        } else {
            return null;
        }
    }

    // Delete ninja by id
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

}
