package dev.decagon.activity_tracker.repositories;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
//
//    @Query(value = "SELECT * FROM task WHERE status=0 AND user_id=?1",nativeQuery = true)
//    List<Task> findAllPendingTasks(Long userId);
//
//    @Query("SELECT t FROM Task t WHERE t.status='IN_PROGRESS' AND t.user.id=?1")
//    List<Task> findAllInProgressTasks(Long userId);
//
//    @Query("SELECT t FROM Task t WHERE t.status='DONE' AND t.user.id=?1")
//    List<Task> findAllDoneTasks(Long userId);
//
//    List<Task> findAllUserTasks(Long userId);
}
