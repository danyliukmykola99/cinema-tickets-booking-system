package danyliuk.mykola.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "public",name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Integer seat;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public boolean isAvailable(){
        return status.equals(TicketStatus.AVAILABLE);
    }

    public boolean isReserved(){
        return status.equals(TicketStatus.RESERVED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}