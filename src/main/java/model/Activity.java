package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private String name;
    private String description;
    private int maxCapacity;
    private List<User> users = new ArrayList<>();

    public Activity(String name, String description, int maxCapacity) {
        this.name = name;
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