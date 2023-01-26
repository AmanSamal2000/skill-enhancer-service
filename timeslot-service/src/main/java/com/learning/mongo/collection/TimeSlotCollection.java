package com.learning.mongo.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "timeSlot")
public class TimeSlotCollection {

    @Id
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long trainerId;

}
