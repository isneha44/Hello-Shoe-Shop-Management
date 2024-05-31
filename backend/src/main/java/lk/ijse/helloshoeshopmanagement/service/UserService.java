package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> findById(UUID id);
    boolean deleteUser(User id);
}
