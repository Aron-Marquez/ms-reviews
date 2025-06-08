package pe.edu.upeu.msreviews.service;

import pe.edu.upeu.msreviews.entity.Review;

import java.util.List;

public interface IReviewService {
        List<Review> getAllReviews();
        Review CreateReview(Review review);
        Review UpdateReview(Long id, Review review);
        void DeleteReview(Long id);
        Review GetReviewById(Long id);
        List<Review> getReviewsByProductId(Long productoId);
        List<Review> getReviewsByUserId(Long usuarioId);
}