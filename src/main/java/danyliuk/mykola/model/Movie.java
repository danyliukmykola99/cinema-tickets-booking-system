package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table
public class Movie {

    @Id
    private UUID id;
    private String title;
    private String description;
    @OneToMany
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