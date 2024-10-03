package controller;

import model.Activity;
import service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appActivitats/activities")
public class ActivityController {

    @Autowired
    private ActivityServiceImpl activityServiceImpl;

    @PostMapping("/activity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityServiceImpl.createActivity(activity);
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityServiceImpl.getActivities();
    }

    @PostMapping("/join/{activityId}/{userId}")
    public void joinActivity(@PathVariable String activityId, @PathVariable String userId) {
        activityServiceImpl.joinActivity(activityId, userId);
    }

    @GetMapping("/export")
    public String exportActivities() {
        return activityServiceImpl.exportActivities();
    }

    @PostMapping("/import")
    public void importActivities(@RequestBody String json) {
        activityServiceImpl.importActivities(json);
    }
}