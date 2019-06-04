package danyliuk.mykola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    private UUID id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String name;
    @OneToMany
    private List<Ticket> tickets;

    public boolean isAdmin(){
        return roleType.equals(RoleType.ADMIN);
    }

    public boolean isClient(){
        return roleType.equals(RoleType.CLIENT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}