package com.asli.weblabodev4.service;

import com.asli.weblabodev4.model.Plant;
import java.util.List;

public interface PlantService {
    List<Plant> getAllPlants();
    Plant getPlantById(Long id);
    Plant savePlant(Plant plant);
    void deletePlant(Long id);
    List<Plant> searchPlants(String keyword);
}
