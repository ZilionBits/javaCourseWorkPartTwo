package lt.techin.springTest.repositories;

import lt.techin.springTest.controllers.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
