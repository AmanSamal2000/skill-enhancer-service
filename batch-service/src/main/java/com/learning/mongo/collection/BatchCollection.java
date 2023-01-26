package com.learning.mongo.collection;

import com.learning.enums.BatchStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "batch")
public class BatchCollection {

    @Id
    private Long id;
    private Integer studentCount;
    private LocalDate startDate;
    private LocalDate endDate;
    private BatchStatus batchStatus;
    private Long courseId;
    private Long timeSlotId;
}
