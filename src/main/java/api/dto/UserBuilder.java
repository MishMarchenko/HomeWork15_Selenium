package api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBuilder {
    Integer id;
    String username;
    String firstname;
    String lastname;
    String email;
    String password;
    String phone;
    String userStatus;

}
