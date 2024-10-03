package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private String name;
    private String description;
    private String date;
}