package lt.stud.techin.coursesmanagement.services;


import lt.stud.techin.coursesmanagement.model.Course;
import lt.stud.techin.coursesmanagement.rest.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();
    Course addCourse(CourseRequest courseRequest);

}
