package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDTO {

    private UUID id;
    private String movieTitle;
    private UUID movieId;
    private String startDateTime;
    private String startTime;
    private String startDate;
    private String status;
    private Integer availableTicketsCount;
    private Integer reservedTicketsCount;
    private TicketDTO[][] ticketDTOS;
    private List<TicketDTO> tickets;

    public ShowDTO(Show show){
        this.id = show.getId();
        this.movieTitle = show.getMovie().getTitle();
        this.startDateTime = show.getStart().toString();
        this.startDate = show.getStart().toLocalDate().toString();
        this.status = show.getStatus().getName();
        this.startTime = show.getStart().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));
        this.reservedTicketsCount = Math.toIntExact(show.getTickets().stream().filter(Ticket::isReserved).count());
        this.availableTicketsCount = Math.toIntExact(show.getTickets().stream().filter(Ticket::isAvailable).count());
        this.tickets = show.getTickets().stream().map(TicketDTO::new).collect(Collectors.toList());
    }

    public boolean isAvailableTicketWithNumber(int number){
        Optional<TicketDTO> ticket = tickets.stream().filter(t -> t.getSeat() == number).findFirst();
        return ticket.get().getAvailable();
    }

}
