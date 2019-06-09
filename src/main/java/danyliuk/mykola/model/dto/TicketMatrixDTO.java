package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Getter
public class TicketMatrixDTO {

    private TicketDTO[][] matrix;

    public TicketMatrixDTO(Show show){
        List<Ticket> list = show.getTickets().stream().sorted(Comparator.comparing(Ticket::getSeat)).collect(Collectors.toList());
        this.matrix = new TicketDTO[10][10];
        for(int i = 0; i<100 ; i++){
            this.matrix[i/10][i%10] = new TicketDTO(list.get(i));
        }
    }
}
