package com.asli.weblabodev4.controller;
import com.asli.weblabodev4.model.Plant;
import com.asli.weblabodev4.service.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public String listPlants(@RequestParam(required = false) String search, Model model) {
        List<Plant> plants = (search != null && !search.isEmpty())
                ? plantService.searchPlants(search)
                : plantService.getAllPlants();
        model.addAttribute("plants", plants);
        return "plant/list";
    }

    @GetMapping("/create")
    public String createPlantForm(Model model) {
        model.addAttribute("plant", new Plant());
        return "plant/create";
    }

    @PostMapping
    public String savePlant(@ModelAttribute("plant") Plant plant) {
        plantService.savePlant(plant);
        return "redirect:/plants";
    }

    @GetMapping("/edit/{id}")
    public String editPlantForm(@PathVariable Long id, Model model) {
        model.addAttribute("plant", plantService.getPlantById(id));
        return "plant/edit";
    }

    @PostMapping("/{id}")
    public String updatePlant(@PathVariable Long id, @ModelAttribute("plant") Plant plant) {
        plant.setId(id);
        plantService.savePlant(plant);
        return "redirect:/plants";
    }

    @GetMapping("/delete/{id}")
    public String deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return "redirect:/plants";
    }
}
