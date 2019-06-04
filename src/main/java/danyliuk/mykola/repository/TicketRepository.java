package danyliuk.mykola.repository;

import danyliuk.mykola.model.Ticket;
import danyliuk.mykola.model.TicketStatus;
import danyliuk.mykola.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Optional<Ticket> findByShow_IdAndSeat(UUID showID, int seat);
    List<Ticket> findByStatusAndUser(TicketStatus status, User user);
}
