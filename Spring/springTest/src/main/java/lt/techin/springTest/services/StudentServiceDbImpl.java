package lt.techin.springTest.services;

import lt.techin.springTest.controllers.Student;
import lt.techin.springTest.dto.StudentRequest;
import lt.techin.springTest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceDbImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceDbImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void createStudent(StudentRequest studentRequest) {

        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());

        studentRepository.save(student);

//        studentRepository.save(studentRequest);
    }
}
