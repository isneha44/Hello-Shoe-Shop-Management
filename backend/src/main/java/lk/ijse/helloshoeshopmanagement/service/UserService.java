package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailService();
    UserDTO searchUser(String id);
    UserDTO searchUserNam(String name);
    void deleteUser(String email);
}
