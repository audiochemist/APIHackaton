package dto;

import lombok.Data;

@Data
public class ActivityJsonDTO {
    private String nameActivity;
    private String description;
    private int maxCapacity;
}