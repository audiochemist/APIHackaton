package service;

import model.Activity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ActivityService {
    Activity createActivity(Activity activity);
    List<Activity> getActivities();
    void joinActivity(String activityId, String userId);
    String exportActivities();
    void importActivities(String jsonFilePath) throws IOException;
    Optional<Activity> getActivityById(String id);
    Activity updateActivity(Activity activity);
    void deleteActivity(String id);
}