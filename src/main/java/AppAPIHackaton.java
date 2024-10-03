import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "repository", "model", "exceptions", "config"})
@EnableMongoRepositories(basePackages = "repository")
public class AppAPIHackaton {

    public static void main(String[] args) {
        SpringApplication.run(AppAPIHackaton.class, args);
    }
}