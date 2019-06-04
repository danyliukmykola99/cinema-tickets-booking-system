package danyliuk.mykola.repository;

import danyliuk.mykola.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Mykola Danyliuk
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}