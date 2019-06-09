package danyliuk.mykola.service;

import danyliuk.mykola.model.domain.User;

/**
 * @author Mykola Danyliuk
 */
public interface UserService {
    void save(User user);
    void login(String email, String password);
    User findByEmail(String email);
}
