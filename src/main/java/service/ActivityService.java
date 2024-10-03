package service;

import model.Activity;

import java.util.List;

public interface ActivityService {
    Activity createActivity(Activity activity);
    List<Activity> getActivities();
    void joinActivity(String activityId, String userId);
    String exportActivities();
    void importActivities(String jsonFilePath);
}