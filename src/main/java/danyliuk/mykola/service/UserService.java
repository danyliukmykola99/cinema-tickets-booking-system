package danyliuk.mykola.service;

import danyliuk.mykola.model.User;
import danyliuk.mykola.service.exception.InvalidEmailException;
import danyliuk.mykola.service.exception.PasswordMissmatchException;

import java.util.Optional;

/**
 * @author Mykola Danyliuk
 */
public interface UserService {
    void save(User user);
    User login(String email, String password) throws InvalidEmailException, PasswordMissmatchException;
    boolean emailTaken(String email);

    Optional<User> findByEmail(String email);
}
