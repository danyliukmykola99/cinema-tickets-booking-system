package danyliuk.mykola.repository;

import danyliuk.mykola.model.Show;
import danyliuk.mykola.model.ShowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface ShowRepository extends JpaRepository<Show, UUID> {
    List<Show> findByStatus(ShowStatus status);
    List<Show> findByMovie_Id(UUID movieID);
    List<Show> findByStart_DateAndStatus(LocalDate date, ShowStatus status);
}
