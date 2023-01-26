package com.learning.service.impl;

import com.learning.constants.NumberConstants;
import com.learning.entity.StudentEntity;
import com.learning.model.StudentModel;
import com.learning.repository.StudentRepository;
import com.learning.service.CommonService;
<<<<<<< HEAD
import com.learning.utility.StudentReader;
=======
>>>>>>> 27acf588173fedf550d16ac17dd8700fd30674e9
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
=======

>>>>>>> 27acf588173fedf550d16ac17dd8700fd30674e9
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements CommonService<StudentModel, Long> {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentModel> getAllRecords() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if (!CollectionUtils.isEmpty(studentEntityList)) {
            List<StudentModel> studentModelList = studentEntityList.stream().map(studentEntity -> {

                StudentModel studentModel = new StudentModel();
                modelMapper.map(studentEntity, studentModel);
                return studentModel;
            }).collect(Collectors.toList());
            return studentModelList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<StudentModel> getLimitedRecords(int count) {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if (Objects.nonNull(studentEntityList) && studentEntityList.size() > NumberConstants.ZERO) {
            List<StudentModel> studentModelList = studentEntityList.stream()
                    .limit(count)
                    .map(studentEntity -> {
                        StudentModel studentModel = modelMapper.map(studentEntity, StudentModel.class);
                        return studentModel;
                    })
                    .collect(Collectors.toList());
            return studentModelList;
        } else {
            return Collections.emptyList();
        }
    }


    @Override
    public List<StudentModel> getSortedRecords(String sortBy) {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if (Objects.nonNull(studentEntityList) && studentEntityList.size() > NumberConstants.ZERO) {
            Comparator<StudentEntity> comparator = findSuitableComparator(sortBy);
            List<StudentModel> studentModelList = studentEntityList.stream()
                    .sorted(comparator)
                    .map(studentEntity -> {
                        StudentModel studentModel = modelMapper.map(studentEntity, StudentModel.class);
                        return studentModel;
                    })
                    .collect(Collectors.toList());
            return studentModelList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public StudentModel saveRecord(StudentModel record) {
        if (Objects.nonNull(record)) {
            StudentEntity studentEntity = new StudentEntity();
            modelMapper.map(record, studentEntity);
            studentRepository.save(studentEntity);
        }
        return record;
    }

    @Override
    public List<StudentModel> saveAll(List<StudentModel> studentModelList) {
        if (Objects.nonNull(studentModelList) && studentModelList.size() > NumberConstants.ZERO) {
            List<StudentEntity> studentEntityList = studentModelList.stream()
                    .map(studentModel -> {
                        StudentEntity entity = modelMapper.map(studentModel, StudentEntity.class);
                        return entity;
                    })
                    .collect(Collectors.toList());
            studentRepository.saveAll(studentEntityList);
        }
        return studentModelList;
    }


    @Override
    public Optional<StudentModel> getRecordById(Long id) {
        Optional<StudentEntity> optionalEntity = studentRepository.findById(id);
        if (optionalEntity.isPresent()) {
            StudentEntity studentEntity = optionalEntity.get();
            StudentModel studentModel = modelMapper.map(studentEntity, StudentModel.class);
            return Optional.of(studentModel);
        }
        return Optional.empty();
    }

    @Override
    public void deleteRecordById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentModel updatedRecordById(Long id, StudentModel record) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            modelMapper.map(record, studentEntity);
            studentEntity.setId(id);
            studentRepository.save(studentEntity);
        }
        return record;
    }

<<<<<<< HEAD
    public void saveExcelFile(MultipartFile file) {
        if (file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            try {
                List<StudentEntity> studentEntityList = StudentReader.getStudentObjects(file.getInputStream());
                studentRepository.saveAll(studentEntityList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<StudentModel> getDataFromExcel() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        if (Objects.nonNull(studentEntityList) && studentEntityList.size() > NumberConstants.ZERO) {
            List<StudentModel> studentModelList = studentEntityList.stream().map(studentEntity -> {
                StudentModel studentModel = modelMapper.map(studentEntity, StudentModel.class);
                return studentModel;
            }).collect(Collectors.toList());
            return studentModelList;
        } else {
            return Collections.emptyList();
        }
    }


=======
>>>>>>> 27acf588173fedf550d16ac17dd8700fd30674e9

    private Comparator<StudentEntity> findSuitableComparator(String sortBy) {
        Comparator<StudentEntity> comparator;
        switch (sortBy) {
            case "name": {
                comparator = (studentOne, studentTwo) ->
                        studentOne.getName().compareTo(studentTwo.getName());
                break;
            }
            case "email": {
                comparator = (studentOne, studentTwo) ->
                        studentOne.getEmail().compareTo(studentTwo.getEmail());
                break;
            }
            default: {
                comparator = (studentOne, studentTwo) ->
                        studentOne.getId().compareTo(studentTwo.getId());
            }
        }
        return comparator;
    }


}
