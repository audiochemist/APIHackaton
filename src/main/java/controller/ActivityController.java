package controller;

import model.Activity;
import service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appActivitats/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @PostMapping("/join/{activityId}/{userId}")
    public void joinActivity(@PathVariable String activityId, @PathVariable String userId) {
        activityService.joinActivity(activityId, userId);
    }

    @GetMapping("/export")
    public String exportActivities() {
        return activityService.exportActivities();
    }

    @PostMapping("/import")
    public void importActivities(@RequestBody String json) {
        activityService.importActivities(json);
    }
}