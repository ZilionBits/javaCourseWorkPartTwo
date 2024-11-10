package lt.techin.springTest.services;

import lt.techin.springTest.controllers.Student;
import lt.techin.springTest.dto.StudentRequest;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService{

    private final List<Student> students = new ArrayList<>();

    @Override
    public Student getStudentById(long id) {
        return students.get((int)id);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void createStudent(StudentRequest student) {
//        students.add(student);
    }
}
