package com.learning.rest;

import com.learning.model.StudentBatchModel;
import com.learning.service.impl.StudentBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentBatch")
@RequiredArgsConstructor
public class StudentBatchController {

    private final StudentBatchService studentBatchService;


    @GetMapping
    public List<StudentBatchModel> getAllStudentBatch() {
        return studentBatchService.getAllRecords();
    }

    @PostMapping
    public StudentBatchModel save(@RequestBody StudentBatchModel studentBatchModel) {
        return studentBatchService.saveRecord(studentBatchModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentBatchService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public StudentBatchModel updateById(@PathVariable Long id, @RequestBody StudentBatchModel studentBatchModel) {
        return studentBatchService.updatedRecordById(id, studentBatchModel);
    }
}
