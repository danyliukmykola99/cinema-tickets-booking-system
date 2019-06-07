package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowDTO {

    private UUID id;
    private String startTime;

    public ShowDTO(Show show){
        this.id = show.getId();
        this.startTime = show.getStart().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));
    }

}
