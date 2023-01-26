package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotModel {


    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long trainerId;

}
