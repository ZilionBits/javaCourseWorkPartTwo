package lt.stud.techin.coursesmanagement.services;


import lt.stud.techin.coursesmanagement.model.Course;
import lt.stud.techin.coursesmanagement.rest.CourseRequest;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> getCoursesByDescription(String description);
    Course addCourse(CourseRequest courseRequest);
    void deleteCourse(Long id);

}
