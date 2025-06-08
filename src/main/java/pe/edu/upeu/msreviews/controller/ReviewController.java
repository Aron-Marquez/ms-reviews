package pe.edu.upeu.msreviews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msreviews.entity.Review;
import pe.edu.upeu.msreviews.repository.IReviewRepository;
import pe.edu.upeu.msreviews.service.IReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final IReviewService reviewService;


    @PostMapping
    public ResponseEntity<Review> CreateReview(@RequestBody Review review) {
        Review created = reviewService.CreateReview(review);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Review>> GetAllReviews() {
        try {
            List<Review> reviews = reviewService.getAllReviews();
            if (reviews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> UpdateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updated = reviewService.UpdateReview(id, review);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteReview(@PathVariable Long id) {
        reviewService.DeleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> GetReview(@PathVariable Long id) {
        Review review = reviewService.GetReviewById(id);
        return ResponseEntity.ok(review);
    }

    // Obtener reseñas por ID de producto
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    // Obtener reseñas por ID de usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable Long userId) {
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }
}
