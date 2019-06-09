package danyliuk.mykola.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "show")
public class Show {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Enumerated(EnumType.STRING)
    private ShowStatus status;
    private LocalDateTime start;
    private LocalDateTime finish;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "show")
    private List<Ticket> tickets = new ArrayList<>();

    public int soldCount(){
        return (int) tickets.stream().filter(Ticket::isReserved).count();
    }

    public int availableCount(){
        return (int) tickets.stream().filter(Ticket::isAvailable).count();
    }

    public boolean isAvailableTicketWithNumber(int number){
        Optional<Ticket> ticket = tickets.stream().filter(t -> t.getSeat() == number).findFirst();
        return ticket.get().isAvailable();
    }

    public boolean isScheduled(){
        return status.equals(ShowStatus.SCHEDULED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return id.equals(show.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}