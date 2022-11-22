package dev.decagon.activity_tracker.repositories;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllPendingTasks(Long userId);

    List<Task> findAllInProgressTasks(Long userId);

    List<Task> findAllDoneTasks(Long userId);

    List<Task> findAllUserTasks(Long userId);
}
