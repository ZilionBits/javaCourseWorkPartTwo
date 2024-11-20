package lt.techin.jparelationships.manytomany.simplepkextracolumn.repository;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Reviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {
}
