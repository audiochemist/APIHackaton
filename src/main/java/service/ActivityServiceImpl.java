package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ActivityJsonDTO;
import exceptions.ActivityIsFullException;
import exceptions.ActivityNotFoundException;
import exceptions.InvalidActivityDataException;
import exceptions.UserNotFoundException;
import model.Activity;
import model.User;
import repository.ActivityRepository;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Activity createActivity(Activity activity) {
        if (activity.getNameActivity() == null || activity.getDescription() == null) {
            throw new InvalidActivityDataException("Activity name and description cannot be null");
        }
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void joinActivity(String activityId, String userId) {
        Activity activity = activityRepository.findById(activityId).orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
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
        File file = new File(jsonFilePath);
        if (!file.exists()) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Activity> activities = objectMapper.readValue(file, new TypeReference<List<Activity>>() {});
            activityRepository.saveAll(activities);
        } catch (IOException e) {
            throw new RuntimeException("Failed to import activities from JSON file", e);
        }
    }

    public void addActivitiesFromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ActivityJsonDTO> activityJsonDTOList;
        try {
            activityJsonDTOList = objectMapper.readValue(json, new TypeReference<List<ActivityJsonDTO>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (ActivityJsonDTO activityJsonDTO : activityJsonDTOList) {
            Activity activity = new Activity();
            activity.setNameActivity(activityJsonDTO.getNameActivity());
            activity.setDescription(activityJsonDTO.getDescription());
            activity.setMaxCapacity(activityJsonDTO.getMaxCapacity());
            activityRepository.save(activity);
        }
    }

    @Override
    public Optional<Activity> getActivityById(String id) {
        return activityRepository.findById(id);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        if (activity.getNameActivity() == null || activity.getDescription() == null) {
            throw new InvalidActivityDataException("Activity name and description cannot be null");
        }
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }
}