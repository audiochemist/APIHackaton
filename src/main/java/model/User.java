package model;

import dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String registrationDate;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.age = userDTO.getAge();
        this.email = userDTO.getEmail();
    }

    public void updateFromDTO(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.age = userDTO.getAge();
        this.email = userDTO.getEmail();
    }
}