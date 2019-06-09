package danyliuk.mykola.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Mykola Danyliuk
 */
@Getter
public class TimeDTO {

    private String time;

    public TimeDTO(LocalDateTime dateTime){
        this.time = dateTime.format(DateTimeFormatter.ofPattern("dd-MM HH:mm", Locale.US));
    }

    @Override
    public String toString() {
        return time;
    }
}
