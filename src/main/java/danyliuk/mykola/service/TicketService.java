package danyliuk.mykola.service;

import danyliuk.mykola.model.domain.Ticket;
import danyliuk.mykola.model.domain.User;
import danyliuk.mykola.service.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface TicketService {
    List<Ticket> findReservedByUser(User user);
    void reserveTicket(UUID showID, int seat, User user) throws NotFoundException;
}
