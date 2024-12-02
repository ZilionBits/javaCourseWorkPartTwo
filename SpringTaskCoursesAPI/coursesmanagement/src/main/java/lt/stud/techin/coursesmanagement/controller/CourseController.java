package lt.stud.techin.coursesmanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.stud.techin.coursesmanagement.exceptions.StartDateIsGreaterThanEndDateException;
import lt.stud.techin.coursesmanagement.model.Course;
import lt.stud.techin.coursesmanagement.repository.CourseRepository;
import lt.stud.techin.coursesmanagement.rest.CourseRequest;
import lt.stud.techin.coursesmanagement.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;


    @GetMapping
    public ResponseEntity<List<Course>> getCoursesByDescription(@RequestParam String description){
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseRepository.findAll().stream()
                        .filter(c -> c.getDescription().contains(description)).toList());
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody @Valid CourseRequest courseRequest){

        if(courseRequest.getStartDate().isAfter(courseRequest.getEndDate())){
            throw new StartDateIsGreaterThanEndDateException("Start Date is after End Date.");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.addCourse(courseRequest));

    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Course successfully deleted.");
    }





}
