package service;

import model.Activity;
import repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public void joinActivity(String activityId, String userId) {
        // Implement join activity logic
    }

    public String exportActivities() {
        // Implement export activities logic
        return "";
    }

    public void importActivities(String json) {
        // Implement import activities logic
    }
}