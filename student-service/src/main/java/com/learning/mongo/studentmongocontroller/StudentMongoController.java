package com.learning.mongo.studentmongocontroller;

import com.learning.model.StudentModel;
import com.learning.mongo.studentmongoservice.StudentMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student-mongo")
@RequiredArgsConstructor
public class StudentMongoController {

    private final StudentMongoService studentMongoService;


    @GetMapping
    public List<StudentModel> getAllStudent() {
        return studentMongoService.getAllRecords();
    }

    @PostMapping
    public StudentModel save(@RequestBody StudentModel studentModel) {
        return studentMongoService.saveRecord(studentModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentMongoService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public StudentModel updateById(@PathVariable Long id, @RequestBody StudentModel studentModel) {
        return studentMongoService.updatedRecordById(id, studentModel);
    }
}

