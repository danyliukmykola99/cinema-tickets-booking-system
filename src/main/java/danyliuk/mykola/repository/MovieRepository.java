package danyliuk.mykola.repository;

import danyliuk.mykola.model.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
