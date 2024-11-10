package lt.techin.springTaskOne.rest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserPrank, Long> {
}
