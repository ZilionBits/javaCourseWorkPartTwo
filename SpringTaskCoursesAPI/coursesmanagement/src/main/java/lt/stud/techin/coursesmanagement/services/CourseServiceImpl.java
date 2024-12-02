package lt.stud.techin.coursesmanagement.services;

import lombok.RequiredArgsConstructor;
import lt.stud.techin.coursesmanagement.exceptions.CourseByIdNotExistException;
import lt.stud.techin.coursesmanagement.model.Course;
import lt.stud.techin.coursesmanagement.repository.CourseRepository;
import lt.stud.techin.coursesmanagement.rest.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getCoursesByDescription(String description) {
        return courseRepository.findAll().stream()
                .filter(c -> c.getDescription().contains(description)).toList();
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

    @Override
    public void deleteCourse(Long id) {
        if(courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new CourseByIdNotExistException();
        }
    }

    @Override
    public Course updateCourse(Long id, CourseRequest courseRequest) {

            Course selectedCourse = courseRepository.findById(id)
                    .orElseThrow(CourseByIdNotExistException::new);

            selectedCourse.setName(courseRequest.getName());
            selectedCourse.setDescription(courseRequest.getDescription());
            selectedCourse.setType(courseRequest.isType() ? "Live" : "Online");
            selectedCourse.setStartDate(courseRequest.getStartDate());
            selectedCourse.setEndDate(courseRequest.getEndDate());

            return selectedCourse;
    }
}
