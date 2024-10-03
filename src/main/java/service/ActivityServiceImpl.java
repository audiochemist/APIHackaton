package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ActivityIsFullException;
import exceptions.ResourceNotFoundException;
import model.Activity;
import model.User;
import repository.ActivityRepository;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void joinActivity(String activityId, String userId) {
        Activity activity = activityRepository.findById(activityId).orElseThrow(() -> new ResourceNotFoundException("Activity not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        try {
            activity.addUser(user);
        } catch (RuntimeException e) {
            throw new ActivityIsFullException("Activity is full");
        }
        activityRepository.save(activity);
    }

    @Override
    public String exportActivities() {
        List<Activity> activities = activityRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(activities);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to export activities to JSON", e);
        }
    }

    @Override
    public void importActivities(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Activity> activities = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Activity>>() {});
            activityRepository.saveAll(activities);
        } catch (IOException e) {
            throw new RuntimeException("Failed to import activities from JSON file", e);
        }
    }
}