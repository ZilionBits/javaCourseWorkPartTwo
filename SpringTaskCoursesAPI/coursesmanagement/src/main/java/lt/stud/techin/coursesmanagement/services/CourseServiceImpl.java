package lt.stud.techin.coursesmanagement.services;

import lombok.RequiredArgsConstructor;
import lt.stud.techin.coursesmanagement.model.Course;
import lt.stud.techin.coursesmanagement.repository.CourseRepository;
import lt.stud.techin.coursesmanagement.rest.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {

        Course newCourse = new Course();

        newCourse.setName(courseRequest.getName());
        newCourse.setDescription(courseRequest.getDescription());
        newCourse.setType(courseRequest.isType() ? "Live" : "Online");
        newCourse.setStartDate(courseRequest.getStartDate());
        newCourse.setEndDate(courseRequest.getEndDate());
        courseRepository.save(newCourse);

        return newCourse;
    }
}
