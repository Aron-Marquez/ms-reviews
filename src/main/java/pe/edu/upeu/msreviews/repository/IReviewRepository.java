package pe.edu.upeu.msreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.msreviews.entity.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUsuarioIdAndProductoId(Long usuarioId, Long productoId);

    List<Review> findAllByProductoId(Long productoId);

    List<Review> findAllByUsuarioId(Long usuarioId);
}
