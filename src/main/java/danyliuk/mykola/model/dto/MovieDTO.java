package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
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
    private Set<ShowDTO> shows;

    public MovieDTO(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.shows = movie.getShows().stream().map(ShowDTO::new).collect(Collectors.toSet());
    }

}
