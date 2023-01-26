package com.learning.mongo.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trainer")
public class TrainerCollection {

    @Id
    private Long id;
    private String name;
    private String specialization;
}

