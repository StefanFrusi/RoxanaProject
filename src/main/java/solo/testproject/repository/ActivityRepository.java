package solo.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.testproject.entity.Activity;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    Optional<Activity> findByName(String name);
}
