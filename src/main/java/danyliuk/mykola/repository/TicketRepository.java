package danyliuk.mykola.repository;

import danyliuk.mykola.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
