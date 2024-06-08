package lk.ijse.helloshoeshopmanagement.dto;



import lk.ijse.helloshoeshopmanagement.enums.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String id;
    private String email;
    private String password;
    private Role role;
}
