package lt.techin.jparelationships.onetoone.simplepk.repository;

import lt.techin.jparelationships.onetoone.simplepk.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
