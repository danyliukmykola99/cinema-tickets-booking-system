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
    private Boolean available;
    private Integer seat;

    public TicketDTO(Ticket ticket){
        this.id = ticket.getId();
        this.available = ticket.isAvailable();
        this.seat = ticket.getSeat();
    }

}
