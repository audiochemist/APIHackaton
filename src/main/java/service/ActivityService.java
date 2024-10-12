package service;

import dto.ActivityDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ActivityService {
    ActivityDTO createActivity(ActivityDTO activityDTO);
    List<ActivityDTO> getActivities();
    void joinActivity(String activityId, String userId);
    String exportActivities();
    void importActivities(String jsonFilePath) throws IOException;
    Optional<ActivityDTO> getActivityById(String id);
    ActivityDTO updateActivity(ActivityDTO activityDTO);
    void deleteActivity(String id);
}