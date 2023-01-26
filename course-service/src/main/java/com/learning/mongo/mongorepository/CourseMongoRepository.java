package com.learning.mongo.mongorepository;

import com.learning.mongo.collection.CourseCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseMongoRepository extends MongoRepository<CourseCollection, Long> {

}
