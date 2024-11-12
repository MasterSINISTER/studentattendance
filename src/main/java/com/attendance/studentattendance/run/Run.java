package com.attendance.studentattendance.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

public record Run(
        @NotNull
        Integer RollNo,
        @NotEmpty
        String name,
        String status,
        @Positive
        Integer totalPresent,
        @Positive
        Integer totalAbsent) {
}
