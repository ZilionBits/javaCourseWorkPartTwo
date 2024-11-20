package lt.techin.jparelationships.manytomany.simplepkextracolumn.service;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Comment;

public interface CommentService {

    Comment validateAndGetComment(Long id);

    Comment saveComment(Comment comment);

    void deleteComment(Comment comment);
}
