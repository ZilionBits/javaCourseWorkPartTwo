package lt.techin.jparelationships.manytomany.simplepkextracolumn.repository;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
