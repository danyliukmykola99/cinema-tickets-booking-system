package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DayScheduleDTO {

    private String date;
    private Set<MovieDTO> movies;

    public DayScheduleDTO(List<Show> scheduledShowsForWeek, LocalDate date){
        this.date = date.toString();
        this.movies = scheduledShowsForWeek.stream()
                .filter(s -> s.getStart().toLocalDate().equals(date))
                .map(Show::getMovie)
                .map(MovieDTO::new)
                .collect(Collectors.toSet());
    }

}
