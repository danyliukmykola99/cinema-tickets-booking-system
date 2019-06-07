package danyliuk.mykola.service.impl;

import danyliuk.mykola.model.domain.User;
import danyliuk.mykola.repository.UserRepository;
import danyliuk.mykola.service.UserService;
import danyliuk.mykola.service.exception.InvalidEmailException;
import danyliuk.mykola.service.exception.PasswordMissmatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Mykola Danyliuk
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User login(String email, String password) throws InvalidEmailException, PasswordMissmatchException {
        Optional<User> fromDB = findByEmail(email);
        if (!fromDB.isPresent()) {
            throw new InvalidEmailException();
        } else {
            if(!fromDB.get().getPassword().equals(password)){
                throw new PasswordMissmatchException();
            }
        }
        return fromDB.get();
    }

    @Override
    public boolean emailTaken(String email) {
        return findByEmail(email).isPresent();
    }

    @Override
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
