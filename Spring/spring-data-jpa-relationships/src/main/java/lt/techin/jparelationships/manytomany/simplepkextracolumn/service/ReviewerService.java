package lt.techin.jparelationships.manytomany.simplepkextracolumn.service;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Reviewer;

public interface ReviewerService {

    Reviewer validateAndGetReviewer(Long id);

    Reviewer saveReviewer(Reviewer reviewer);

    void deleteReviewer(Reviewer reviewer);
}
