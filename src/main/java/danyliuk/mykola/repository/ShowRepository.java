package danyliuk.mykola.repository;

import danyliuk.mykola.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface ShowRepository extends JpaRepository<Show, UUID> {
}
