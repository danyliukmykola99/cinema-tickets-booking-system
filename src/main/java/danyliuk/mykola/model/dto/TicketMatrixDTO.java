package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.Getter;

import java.util.List;

/**
 * @author Mykola Danyliuk
 */
@Getter
public class TicketMatrixDTO {

    private TicketDTO[][] matrix;

    public TicketMatrixDTO(Show show){
        List<Ticket> list = show.getTickets();
        this.matrix = new TicketDTO[10][10];
        for(int i = 0; i<100 ; i++){
            this.matrix[i/10][i%10] = new TicketDTO(list.get(i));
        }
    }
}
