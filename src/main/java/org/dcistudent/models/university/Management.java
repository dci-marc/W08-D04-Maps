package org.dcistudent.models.university;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
public class Management {
    public static final Double STUDENT_GRADE_TRESHOLD = 70.0;
    Map<String, Student> students = new HashMap<>();

    public Management addStudent(@NotNull Student student) {
        this.students.put(student.getName(), student);

        return this;
    }

    public Double getGrade(@NotBlank String name) {
        return this.students.get(name).getGrade();
    }

    public Double getAverageGrade() {
        Double total = 0.0;

        if (this.students.isEmpty()) {
            return total;
        }

        for (Student student : this.students.values()) {
            total += student.getGrade();
        }

        return total / this.students.size();
    }

    public Double getHighestGrade() {
        Double highest = 0.0;
        for (Student student : this.students.values()) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }

        return highest;
    }

    public Map<String, Student> getAboveGradeThreshold(@NotNull Double threshold) {
        Map<String, Student> aboveThreshold = new HashMap<>();
        for (Student student : this.students.values()) {
            if (student.getGrade() >= threshold) {
                aboveThreshold.put(student.getName(), student);
            }
        }

        return aboveThreshold;
    }
}
