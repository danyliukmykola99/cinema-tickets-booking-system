package danyliuk.mykola.service;

import danyliuk.mykola.model.domain.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface MovieService {
    Optional<Movie> findByID(UUID movieID);
    List<Movie> findAll();
    void save(Movie movie);
}
