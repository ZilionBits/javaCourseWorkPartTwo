package lt.techin.jparelationships.manytomany.simplepkextracolumn.service;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.exception.ReviewerNotFoundException;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Reviewer;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.repository.ReviewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewerServiceImpl implements ReviewerService {

    private final ReviewerRepository reviewerRepository;

    @Override
    public Reviewer validateAndGetReviewer(Long id) {
        return reviewerRepository.findById(id).orElseThrow(() -> new ReviewerNotFoundException(id));
    }

    @Override
    public Reviewer saveReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    @Override
    public void deleteReviewer(Reviewer reviewer) {
        reviewerRepository.delete(reviewer);
    }
}
