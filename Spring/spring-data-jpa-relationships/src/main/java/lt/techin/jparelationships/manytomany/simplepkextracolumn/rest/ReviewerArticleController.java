package lt.techin.jparelationships.manytomany.simplepkextracolumn.rest;

import lt.techin.jparelationships.manytomany.simplepkextracolumn.mapper.ArticleMapper;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.mapper.CommentMapper;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.mapper.ReviewerMapper;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Article;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Comment;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.model.Reviewer;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.ArticleResponse;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CommentResponse;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CreateArticleRequest;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CreateCommentRequest;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.CreateReviewerRequest;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.rest.dto.ReviewerResponse;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.service.ArticleService;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.service.CommentService;
import lt.techin.jparelationships.manytomany.simplepkextracolumn.service.ReviewerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ReviewerArticleController {

    private final ArticleService articleService;
    private final ReviewerService reviewerService;
    private final CommentService commentService;
    private final ReviewerMapper reviewerMapper;
    private final ArticleMapper articleMapper;
    private final CommentMapper commentMapper;

    // --------
    // Reviewer

    @GetMapping("/reviewers/{reviewerId}")
    public ReviewerResponse getReviewer(@PathVariable Long reviewerId) {
        Reviewer reviewer = reviewerService.validateAndGetReviewer(reviewerId);
        return reviewerMapper.toReviewerResponse(reviewer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reviewers")
    public ReviewerResponse createReviewer(@Valid @RequestBody CreateReviewerRequest createReviewerRequest) {
        Reviewer reviewer = reviewerMapper.toReviewer(createReviewerRequest);
        reviewer = reviewerService.saveReviewer(reviewer);
        return reviewerMapper.toReviewerResponse(reviewer);
    }

    @DeleteMapping("/reviewers/{reviewerId}")
    public ReviewerResponse deleteReviewer(@PathVariable Long reviewerId) {
        Reviewer reviewer = reviewerService.validateAndGetReviewer(reviewerId);
        reviewerService.deleteReviewer(reviewer);
        return reviewerMapper.toReviewerResponse(reviewer);
    }

    // -------
    // Article

    @GetMapping("/articles/{articleId}")
    public ArticleResponse getArticle(@PathVariable Long articleId) {
        Article article = articleService.validateAndGetArticle(articleId);
        return articleMapper.toArticleResponse(article);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/articles")
    public ArticleResponse createArticle(@Valid @RequestBody CreateArticleRequest createArticleRequest) {
        Article article = articleMapper.toArticle(createArticleRequest);
        article = articleService.createArticle(article);
        return articleMapper.toArticleResponse(article);
    }

    @DeleteMapping("/articles/{articleId}")
    public ArticleResponse deleteArticle(@PathVariable Long articleId) {
        Article article = articleService.validateAndGetArticle(articleId);
        articleService.deleteArticle(article);
        return articleMapper.toArticleResponse(article);
    }

    // --------
    // Comments

    @GetMapping("/comments/{commentId}")
    public CommentResponse getComment(@PathVariable Long commentId) {
        Comment comment = commentService.validateAndGetComment(commentId);
        return commentMapper.toCommentResponse(comment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/comments")
    public CommentResponse createComment(@Valid @RequestBody CreateCommentRequest createCommentRequest) {
        Comment comment = commentMapper.toComment(createCommentRequest);
        comment = commentService.saveComment(comment);
        return commentMapper.toCommentResponse(comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public CommentResponse deleteComment(@PathVariable Long commentId) {
        Comment comment = commentService.validateAndGetComment(commentId);
        commentService.deleteComment(comment);
        return commentMapper.toCommentResponse(comment);
    }
}
