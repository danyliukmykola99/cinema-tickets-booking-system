package danyliuk.mykola.service.impl;

import danyliuk.mykola.model.*;
import danyliuk.mykola.repository.ShowRepository;
import danyliuk.mykola.service.ShowService;
import danyliuk.mykola.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    private final static int CAPACITY = 100;
    private final static double DEFAULT_PRICE = 50.00;

    @Override
    public Show findByID(UUID showID) throws NotFoundException {
        return showRepository.findById(showID).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Show> findAll() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> findScheduled() {
        return showRepository.findByStatus(ShowStatus.SCHEDULED);
    }

    @Override
    public void cancelAllByMovieID(UUID movieID) {
        List<Show> shows = showRepository.findByMovie_Id(movieID);
        shows.forEach(s -> {
            try {
                cancelByShowID(s.getId());
            } catch (NotFoundException ignored) {}
        });
    }

    @Override
    public void cancelByShowID(UUID showID) throws NotFoundException {
        Show show = findByID(showID);
        show.setStatus(ShowStatus.CANCELED);
        show.getTickets().forEach(t->t.setStatus(TicketStatus.CANCELED));
        showRepository.save(show);
    }

    @Override
    public void startByShowID(UUID showID) throws NotFoundException {
        Show show = findByID(showID);
        show.setStatus(ShowStatus.STARTED);
        showRepository.save(show);
    }

    @Override
    public void finishByShowID(UUID showID) throws NotFoundException {
        Show show = findByID(showID);
        show.setStatus(ShowStatus.FINISHED);
        showRepository.save(show);
    }

    @Override
    public void create(UUID movieID, LocalDateTime start, LocalDateTime finish) {
        Show show = Show.builder()
                .movie(Movie.builder()
                        .id(movieID)
                        .build())
                .start(start)
                .finish(finish)
                .status(ShowStatus.SCHEDULED)
                .build();
        List<Ticket> tickets = new LinkedList<>();
        for(int seat = 1;seat<=CAPACITY;seat++){
            tickets.add(Ticket.builder()
                    .show(show)
                    .seat(seat)
                    .price(DEFAULT_PRICE)
                    .status(TicketStatus.AVAILABLE)
                    .build());
        }
        show.setTickets(tickets);
        showRepository.save(show);
    }
}
