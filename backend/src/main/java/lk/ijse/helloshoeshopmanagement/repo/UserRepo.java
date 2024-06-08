package lk.ijse.helloshoeshopmanagement.repo;


import lk.ijse.helloshoeshopmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user u WHERE  u.email = :email", nativeQuery = true)
    User findUserByName( @Param("email") String email);


}
