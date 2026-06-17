package com.java10x.cadastrodeninjas.Ninja.Service;

import com.java10x.cadastrodeninjas.Ninja.Model.NinjaModel;
import com.java10x.cadastrodeninjas.Ninja.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Add ninja
    public NinjaModel addNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
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
