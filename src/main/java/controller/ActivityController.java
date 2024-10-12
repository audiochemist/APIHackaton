package controller;

import dto.ActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<ActivityDTO> getAllActivities() {
        return activityService.getActivities();
    }

    @PostMapping
    public ActivityDTO createActivity(@RequestBody ActivityDTO activityDTO) {
        return activityService.createActivity(activityDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable String id) {
        Optional<ActivityDTO> activityDTO = activityService.getActivityById(id);
        return activityDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable String id, @RequestBody ActivityDTO activityDTO) {
        activityDTO.setId(id);
        ActivityDTO updatedActivity = activityService.updateActivity(activityDTO);
        return ResponseEntity.ok(updatedActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable String id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Activity deleted successfully");
    }

    @PostMapping("/import")
    public ResponseEntity<String> importActivities(@RequestParam String filePath) throws IOException {
        activityService.importActivities(filePath);
        return ResponseEntity.ok("Activities imported successfully");
    }

    @GetMapping("/export")
    public String exportActivities() {
        return activityService.exportActivities();
    }

    @PostMapping("/{activityId}/join/{userId}")
    public ResponseEntity<String> joinActivity(@PathVariable String activityId, @PathVariable String userId) {
        activityService.joinActivity(activityId, userId);
        return ResponseEntity.ok("User joined activity successfully");
    }
}