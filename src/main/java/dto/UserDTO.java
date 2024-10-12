package dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.User;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String registrationDate;

}