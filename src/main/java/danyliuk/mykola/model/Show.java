package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Show {

    @Id
    private UUID id;
    @ManyToOne
    private Movie movie;
    @Enumerated(EnumType.STRING)
    private ShowStatus status;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private ShowTimeSlot timeSlot;
    @OneToMany
    private List<Ticket> tickets;

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