package com.learning.rest;

import com.learning.model.TrainerModel;
import com.learning.service.impl.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;


    @GetMapping
    public List<TrainerModel> getAllTrainer() {
        return trainerService.getAllRecords();
    }

    @PostMapping
    public TrainerModel save(@RequestBody TrainerModel trainerModel) {
        return trainerService.saveRecord(trainerModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        trainerService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public TrainerModel updateById(@PathVariable Long id, @RequestBody TrainerModel trainerModel) {
        return trainerService.updatedRecordById(id, trainerModel);
    }

}
