package com.learning.mongo.studentbatchmongocontroller;


import com.learning.model.StudentBatchModel;
import com.learning.mongo.studentbatchmongoservice.StudentBatchMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentBatch-mongo")
@RequiredArgsConstructor
public class StudentBatchMongoController {

    private final StudentBatchMongoService studentBatchMongoService;


    @GetMapping
    public List<StudentBatchModel> getAllStudentBatch() {
        return studentBatchMongoService.getAllRecords();
    }

    @PostMapping
    public StudentBatchModel save(@RequestBody StudentBatchModel studentBatchModel) {
        return studentBatchMongoService.saveRecord(studentBatchModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentBatchMongoService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public StudentBatchModel updateById(@PathVariable Long id, @RequestBody StudentBatchModel studentBatchModel) {
        return studentBatchMongoService.updatedRecordById(id, studentBatchModel);
    }
}
