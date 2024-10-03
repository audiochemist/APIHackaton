package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private String nameActivity;
    private String description;
    private int maxCapacity;
    private List<User> users = new ArrayList<>();

    public Activity(String name, String description, int maxCapacity) {
        this.nameActivity = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    public void addUser(User user) {
        if (users.size() < maxCapacity) {
            users.add(user);
        } else {
            throw new RuntimeException("Activity is full");
        }
    }
}