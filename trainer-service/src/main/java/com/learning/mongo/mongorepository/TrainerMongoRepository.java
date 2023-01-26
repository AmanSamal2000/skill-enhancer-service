package com.learning.mongo.mongorepository;

import com.learning.mongo.collection.TrainerCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainerMongoRepository extends MongoRepository<TrainerCollection, Long> {
}
