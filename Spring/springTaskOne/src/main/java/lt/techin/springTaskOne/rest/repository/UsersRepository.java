package lt.techin.springTaskOne.rest.repository;

import lt.techin.springTaskOne.rest.users.UserPrank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserPrank, Long> {
}
