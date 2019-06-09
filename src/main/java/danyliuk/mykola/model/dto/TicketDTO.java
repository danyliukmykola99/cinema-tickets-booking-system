package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Getter
public class TicketDTO {

    private UUID id;
    private String movieTitle;
    private String showData;
    private String showTime;
    private Boolean available;
    private Integer seat;

    public TicketDTO(Ticket ticket){
        this.id = ticket.getId();
        this.movieTitle = ticket.getShow().getMovie().getTitle();
        this.showData = ticket.getShow().getStart().toLocalDate().toString();
        this.showTime = ticket.getShow().getStart().toLocalTime().toString();
        this.available = ticket.isAvailable();
        this.seat = ticket.getSeat();
    }

}
