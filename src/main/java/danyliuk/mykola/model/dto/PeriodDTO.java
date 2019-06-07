package danyliuk.mykola.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Mykola Danyliuk
 */
@Getter
public class PeriodDTO {

    private String startTime;
    private String finishTime;

    public PeriodDTO(LocalDateTime start, LocalDateTime finish) {
        this.startTime = start.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));
        this.finishTime = finish.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm", Locale.US));
    }
}
