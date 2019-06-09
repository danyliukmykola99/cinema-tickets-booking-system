package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Movie;
import danyliuk.mykola.model.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
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
        List<Show> scheduledShowsForDay = scheduledShowsForWeek.stream()
                .filter(s -> s.getStart().toLocalDate().equals(date))
                .collect(Collectors.toList());
        Set<MovieDTO> scheduledMoviesForDay = scheduledShowsForDay.stream()
                .map(Show::getMovie)
                .map(MovieDTO::new)
                .collect(Collectors.toSet());
        scheduledMoviesForDay.forEach(movie -> {
            List<ShowDTO> shows = scheduledShowsForDay.stream()
                    .filter(s -> new MovieDTO(s.getMovie()).equals(movie))
                    .sorted(Comparator.comparing(Show::getStart))
                    .map(ShowDTO::new)
                    .collect(Collectors.toList());
            movie.setShows(shows);
        });
        this.movies = scheduledMoviesForDay;
    }

}
