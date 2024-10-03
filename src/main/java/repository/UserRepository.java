package repository;

import model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByid(String id);

    Optional<User> findByfirstName(String firstName);

    Optional<User> findBylastName(String lastName);

    Optional<User> findByEmail(String email);

    List<User> findAllByOrderByRegistrationDate();

    void deleteByfirstName(String firstName);
}
