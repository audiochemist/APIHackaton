package controller;

import model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ActivityService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getActivities();
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @GetMapping("/{id}")
    public Optional<Activity> getActivityById(@PathVariable String id) {
        return activityService.getActivityById(id);
    }

    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable String id, @RequestBody Activity activity) {
        activity.setId(id);
        return activityService.updateActivity(activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable String id) {
        activityService.deleteActivity(id);
    }

    @PostMapping("/import")
    public void importActivities(@RequestParam String filePath) throws IOException {
        activityService.importActivities(filePath);
    }

    @GetMapping("/export")
    public String exportActivities() {
        return activityService.exportActivities();
    }

    @PostMapping("/{activityId}/join/{userId}")
    public void joinActivity(@PathVariable String activityId, @PathVariable String userId) {
        activityService.joinActivity(activityId, userId);
    }
}