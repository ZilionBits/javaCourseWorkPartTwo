package lt.stud.techin.coursesmanagement.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CourseRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String type;
    @DateTimeFormat
    private String startDate;
    @DateTimeFormat
    private String endDate;

}
