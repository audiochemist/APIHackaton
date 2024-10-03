package repository;

import model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {

    Optional<Activity> findById(String id);

    Optional<Activity> findByNameActivity(String name);

    void deleteByNameActivity(String name);

    List<Activity> findByUsers(String userId);
}