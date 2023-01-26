package com.learning.rest;

import com.learning.model.BatchModel;
import com.learning.service.impl.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;


    @GetMapping
    public List<BatchModel> getAllBatch() {
        return batchService.getAllRecords();
    }


    @PostMapping
    public BatchModel save(@RequestBody BatchModel batchModel) {
        return batchService.saveRecord(batchModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        batchService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public BatchModel updateById(@PathVariable Long id, @RequestBody BatchModel batchModel) {
        return batchService.updatedRecordById(id, batchModel);
    }

}
