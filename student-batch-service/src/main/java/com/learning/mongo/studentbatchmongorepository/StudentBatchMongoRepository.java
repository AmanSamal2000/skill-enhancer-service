package com.learning.mongo.studentbatchmongorepository;

import com.learning.mongo.collection.StudentBatchCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentBatchMongoRepository extends MongoRepository<StudentBatchCollection, Long> {

}
