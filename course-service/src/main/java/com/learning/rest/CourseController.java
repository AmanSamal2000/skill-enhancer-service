package com.learning.rest;

import com.learning.model.CourseModel;
import com.learning.service.impl.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    public List<CourseModel> getAllCourse() {
        return courseService.getAllRecords();
    }

    @PostMapping
    public CourseModel save(@RequestBody CourseModel courseModel) {
        return courseService.saveRecord(courseModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteRecordById(id);
    }

    @PutMapping("/{id}")
    public CourseModel updateById(@PathVariable Long id, @RequestBody CourseModel courseModel) {
        return courseService.updatedRecordById(id, courseModel);
    }

}
