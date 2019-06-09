package danyliuk.mykola.model.dto;

import danyliuk.mykola.model.domain.RoleType;
import danyliuk.mykola.model.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mykola Danyliuk
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginForm {

    private String email;
    private String password;

    public User parse(){
        return User.builder()
                .email(email)
                .password(password)
                .role(RoleType.ROLE_CLIENT)
                .build();
    }

}
