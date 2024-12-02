package lt.stud.techin.coursesmanagement.rest;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseRequest {

    @NotBlank(message = "Name must be given.")
    private String name;
    @NotBlank(message = "Description must be given.")
    private String description;
    @NotNull(message = "Only two options true -> Live , false -> Online.")
    private boolean type;
    @Future(message = "Start date can't be in past.")
    private LocalDate startDate;
    @NotNull(message = "Must give end date.")
    private LocalDate endDate;

}
