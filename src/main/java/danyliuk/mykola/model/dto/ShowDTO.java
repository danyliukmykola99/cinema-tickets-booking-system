package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
@AllArgsConstructor
@Builder
public class ShowDTO {

    private UUID id;
    private String movieTitle;
    private String startTime;
    private String startDate;
    private Integer availableTickets;
    private TicketDTO[][] ticketDTOS;
    private List<TicketDTO> tickets;

    public ShowDTO(Show show){
        this.id = show.getId();
        this.movieTitle = show.getMovie().getTitle();
        this.startDate = show.getStart().toLocalDate().toString();
        this.startTime = show.getStart().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));
        this.availableTickets = Math.toIntExact(show.getTickets().stream().filter(Ticket::isAvailable).count());
        this.tickets = show.getTickets().stream().map(TicketDTO::new).collect(Collectors.toList());
    }

    public boolean isAvailableTicketWithNumber(int number){
        Optional<TicketDTO> ticket = tickets.stream().filter(t -> t.getSeat() == number).findFirst();
        return ticket.get().getAvailable();
    }

}
