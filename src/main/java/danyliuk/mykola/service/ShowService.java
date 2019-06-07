package danyliuk.mykola.service;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.service.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface ShowService {
    Show findByID(UUID showID) throws NotFoundException;
    List<Show> findAll();
    List<Show> findScheduled();
    void cancelAllByMovieID(UUID movieID);
    void cancelByShowID(UUID showID) throws NotFoundException;
    void startByShowID(UUID showID) throws NotFoundException;
    void finishByShowID(UUID showID) throws NotFoundException;
    void create(UUID movieID, LocalDateTime start, LocalDateTime finish);
}
