package dev.decagon.activity_tracker.repositories;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT t FROM Task t WHERE t.userId=?1")
    List<Task> findAllUserTasks(Long userId);

    @Query(value = "SELECT * FROM task WHERE user_id=?1 AND status=?2", nativeQuery = true)
    List<Task> findByUserIdAndStatus(Long userId, String name);

}
