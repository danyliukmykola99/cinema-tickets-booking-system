package danyliuk.mykola.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "movie")
public class Movie {

    @Id
    private UUID id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "movie")
    private List<Show> shows;

    public List<Show> getScheduledShows(){
        return shows.stream().filter(Show::isScheduled).collect(Collectors.toList());
    }

    public Set<Show> getScheduledShowsInDay(LocalDate date){
        return shows.stream()
                .filter(Show::isScheduled)
                .filter(s->s.getStart().toLocalDate().equals(date))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}