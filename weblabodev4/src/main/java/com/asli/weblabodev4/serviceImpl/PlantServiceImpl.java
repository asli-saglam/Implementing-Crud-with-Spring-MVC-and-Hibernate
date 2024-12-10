package com.asli.weblabodev4.serviceImpl;

import com.asli.weblabodev4.dao.PlantRepository;
import com.asli.weblabodev4.model.Plant;
import com.asli.weblabodev4.service.PlantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    @Override
    public List<Plant> searchPlants(String keyword) {
        return plantRepository.findByNameContainingIgnoreCase(keyword);
    }


    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    @Override
    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}
