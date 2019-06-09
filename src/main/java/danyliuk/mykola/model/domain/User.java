package danyliuk.mykola.model.domain;

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
@Table(schema = "public", name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    public boolean isAdmin(){
        return role.equals(RoleType.ROLE_ADMIN);
    }

    public boolean isClient(){
        return role.equals(RoleType.ROLE_CLIENT);
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