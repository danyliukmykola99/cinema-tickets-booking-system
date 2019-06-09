package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Movie;
import danyliuk.mykola.model.domain.Show;
import danyliuk.mykola.model.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class MovieDTO {

    private UUID id;
    private String title;
    private String description;
    private Integer reservedTicketsCount;
    private List<ShowDTO> shows;

    public MovieDTO(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.reservedTicketsCount = Math.toIntExact(movie.getShows().stream()
                .map(Show::getTickets)
                .flatMap(Collection::stream)
                .filter(Ticket::isReserved).count());
        this.shows = movie.getShows().stream().map(ShowDTO::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
