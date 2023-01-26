package com.learning.rest;

import com.learning.model.TimeSlotModel;
import com.learning.service.impl.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeSlot")
@RequiredArgsConstructor
public class TimeSlotController {

    private final TimeSlotService timeSlotService;


    @GetMapping
    public List<TimeSlotModel> getAllTimeSlot() {
        return timeSlotService.getAllRecords();
    }

    @PostMapping
    public TimeSlotModel save(@RequestBody TimeSlotModel timeSlotModel) {
        return timeSlotService.saveRecord(timeSlotModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        timeSlotService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public TimeSlotModel updateById(@PathVariable Long id, @RequestBody TimeSlotModel timeSlotModel) {
        return timeSlotService.updatedRecordById(id, timeSlotModel);
    }


}
