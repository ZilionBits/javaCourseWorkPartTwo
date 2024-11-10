package lt.techin.springTest.controllers;

import lt.techin.springTest.dto.StudentRequest;
import lt.techin.springTest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentRequest student) {
        studentService.createStudent(student);
    }

//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable int id){
//        students.remove(id);
//    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
//        Student st = students.get(id);
//        st.setAge(88);
//
//        return st;
//
//    }

}
