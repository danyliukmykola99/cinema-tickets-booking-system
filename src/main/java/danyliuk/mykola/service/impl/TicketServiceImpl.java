package danyliuk.mykola.service.impl;

import danyliuk.mykola.model.domain.Ticket;
import danyliuk.mykola.model.domain.TicketStatus;
import danyliuk.mykola.model.domain.User;
import danyliuk.mykola.repository.TicketRepository;
import danyliuk.mykola.service.TicketService;
import danyliuk.mykola.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findReservedByUser(User user) {
        return ticketRepository.findByStatusAndUser(TicketStatus.RESERVED,user);
    }

    @Override
    public void reserveTicket(UUID showID, int seat, User user) throws NotFoundException {
        Ticket ticket = ticketRepository.findByShow_IdAndSeat(showID, seat).orElseThrow(NotFoundException::new);
        ticket.setStatus(TicketStatus.RESERVED);
        ticket.setUser(user);
        ticketRepository.save(ticket);
    }

}