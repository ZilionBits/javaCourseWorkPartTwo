package lt.techin.springTest.services;

import lt.techin.springTest.controllers.Student;
import lt.techin.springTest.dto.StudentRequest;

import java.util.List;

public interface StudentService {

    Student getStudentById(long id);
    List<Student> getAllStudents();
    void createStudent(StudentRequest student);
    //etc
}
