package danyliuk.mykola.service.impl;

import danyliuk.mykola.model.domain.Movie;
import danyliuk.mykola.repository.MovieRepository;
import danyliuk.mykola.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Optional<Movie> findByID(UUID movieID) {
        return movieRepository.findById(movieID);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
