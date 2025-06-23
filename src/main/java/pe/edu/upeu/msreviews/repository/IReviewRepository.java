package pe.edu.upeu.msreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upeu.msreviews.entity.EstadisticaReviews;
import pe.edu.upeu.msreviews.entity.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUsuarioIdAndProductoId(Long usuarioId, Long productoId);

    List<Review> findAllByProductoId(Long productoId);

    List<Review> findAllByUsuarioId(Long usuarioId);

    @Query("SELECT AVG(r.calificacion) FROM Review r WHERE r.productoId = :productoId")
    Double obtenerPromedioCalificacionPorProducto(Long productoId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.productoId = :productoId")
    Long contarCalificacionesPorProducto(Long productoId);

    @Query("SELECT AVG(r.calificacion) as promedio, COUNT(r) as cantidad FROM Review r WHERE r.productoId = :productoId")
    EstadisticaReviews obtenerEstadisticasPorProducto(Long productoId);
}

