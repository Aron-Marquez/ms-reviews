package pe.edu.upeu.msreviews.service;

<<<<<<< HEAD
import pe.edu.upeu.msreviews.entity.EstadisticaReviews;
=======
>>>>>>> 5ba4c702286f17d12e029dd7047057fa237cd760
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
<<<<<<< HEAD
        EstadisticaReviews obtenerEstadisticasPorProducto(Long productoId);


=======
>>>>>>> 5ba4c702286f17d12e029dd7047057fa237cd760
}