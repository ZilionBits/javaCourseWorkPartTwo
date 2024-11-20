package lt.techin.jparelationships.manytomany.simplepkextracolumn.service;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.exception.CommentNotFoundException;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Comment;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment validateAndGetComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}
