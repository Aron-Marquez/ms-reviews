package pe.edu.upeu.msreviews.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import pe.edu.upeu.msreviews.entity.EstadisticaReviews;
=======
>>>>>>> 5ba4c702286f17d12e029dd7047057fa237cd760
import pe.edu.upeu.msreviews.entity.Review;
import pe.edu.upeu.msreviews.repository.IReviewRepository;
import pe.edu.upeu.msreviews.service.IReviewService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
public class    ReviewServiceImpl implements IReviewService {
=======
public class ReviewServiceImpl implements IReviewService {
>>>>>>> 5ba4c702286f17d12e029dd7047057fa237cd760

    // usuarioClient.obtenerUsuarioPorId(review.getUsuarioId());
    // productoClient.obtenerProductoPorId(review.getProductoId());

    private final IReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review CreateReview(Review review) {
        Optional<Review> existingReview = reviewRepository.findByUsuarioIdAndProductoId(
                review.getUsuarioId(), review.getProductoId()
        );
        if (existingReview.isPresent()) {
            throw new RuntimeException("Ya existe una reseña para este producto por este usuario");
        }

        return reviewRepository.save(review);
    }

    @Override
    public Review UpdateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));

        existingReview.setCalificacion(review.getCalificacion());
        existingReview.setComentario(review.getComentario());

        return reviewRepository.save(existingReview);
    }

    @Override
    public void DeleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review GetReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
    }

    @Override
    public List<Review> getReviewsByProductId(Long productoId) {
        return reviewRepository.findAllByProductoId(productoId);
    }

    @Override
    public List<Review> getReviewsByUserId(Long usuarioId) {
        return reviewRepository.findAllByUsuarioId(usuarioId);
    }
<<<<<<< HEAD

    @Override
    public EstadisticaReviews obtenerEstadisticasPorProducto(Long productoId) {
        return reviewRepository.obtenerEstadisticasPorProducto(productoId);
    }
=======
>>>>>>> 5ba4c702286f17d12e029dd7047057fa237cd760
}
