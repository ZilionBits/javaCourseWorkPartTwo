package lt.techin.jparelationships.manytomany.simplepk.repository;

import lt.techin.jparelationships.manytomany.simplepk.model.Writer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends CrudRepository<Writer, Long> {
}
