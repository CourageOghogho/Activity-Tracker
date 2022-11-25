//package dev.decagon.activity_tracker.services.imple;
//
//import dev.decagon.activity_tracker.exceptions.IllegalEntityStateException;
//import dev.decagon.activity_tracker.exceptions.EntityNotFoundException;
//import dev.decagon.activity_tracker.models.entities.Task;
//import dev.decagon.activity_tracker.models.enums.Status;
//import dev.decagon.activity_tracker.models.pojos.TaskDto;
//import dev.decagon.activity_tracker.models.utils.Mapper;
//import dev.decagon.activity_tracker.repositories.TaskRepository;
//import dev.decagon.activity_tracker.services.TaskService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//public class TaskServiceImpl implements TaskService {
//    private  final TaskRepository taskRepository;
//
//    @Autowired
//    public TaskServiceImpl(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public TaskDto create(TaskDto newTask) {
//        Task task=Task.builder()
//                .title(newTask.getTitle())
//                .description(newTask.getDescription())
//                .build();
//        BeanUtils.copyProperties(taskRepository.save(task),newTask);
//        return newTask;
//    }
//
//    @Override
//    public void delete(Long id) {
//        taskRepository.deleteById(id);
//    }
//
//
//    @Override
//    public Task getTask(Long id) {
//        return taskRepository.findById(id).orElseThrow(
//                ()->new EntityNotFoundException("Task Not Found","No task with the ID in our record"));
//    }
//
//    @Override
//    public List<TaskDto> getTasks() {
//        return taskRepository.findAll().stream()
//                .map(Mapper::taskToDTOMaper)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public TaskDto updateTitle(Long taskId, String newTitle) {
//        Task task=taskRepository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task Not Found",
//                "Task with id : "+taskId+"Not found")); // finds the task in the database or throws exception if not found
//        task.setTitle(newTitle);
//        return Mapper.taskToDTOMaper(taskRepository.saveAndFlush(task)); //returns equivalent dto after persisting the update
//    }
//
//    @Override
//    public TaskDto updateDescription(Long taskId, String newDescription) {
//        Task task=taskRepository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task Not Found",
//                "Task with id : "+taskId+"Not found")); // finds the task in the database or throws exception if not found
//        task.setDescription(newDescription); //change the state of the object
//        return Mapper.taskToDTOMaper(taskRepository.saveAndFlush(task)); //returns equivalent dto after persisting the update
//
//    }
//
//    @Override
//    public TaskDto setPending(TaskDto taskDTO) {
//        Task task=taskRepository.findById(taskDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Task Not Found",
//                "Task with id : "+taskDTO.getId()+"Not found")); // finds the task in the database or throws exception if not found
//        if (task.getStatus()==Status.PENDING) throw new IllegalEntityStateException("Illegal Object Update",
//                "Status cannot be changed to same state");
//        task.setStatus(Status.PENDING); // change the state of the object
//        return Mapper.taskToDTOMaper(taskRepository.saveAndFlush(task)); //returns equivalent dto after persisting the update
//
//    }
//
//    @Override
//    public TaskDto setInProgress(TaskDto taskDTO) {
//        Task task=taskRepository.findById(taskDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Task Not Found",
//                "Task with id : "+taskDTO.getId()+"Not found")); // finds the task in the database or throws exception if not found
//        if (task.getStatus()==Status.IN_PROGRESS) throw new IllegalEntityStateException("Illegal Object Update",
//                "Status cannot be changed to same state");
//        task.setStatus(Status.IN_PROGRESS); // change the state of the object
//        return Mapper.taskToDTOMaper(taskRepository.saveAndFlush(task)); //returns equivalent dto after persisting the update
//
//    }
//
//    @Override
//    public TaskDto setDone(TaskDto taskDTO) {
//        Task task=taskRepository.findById(taskDTO.getId()).orElseThrow(()-> new EntityNotFoundException("Task Not Found",
//                "Task with id : "+taskDTO.getId()+"Not found")); // finds the task in the database or throws exception if not found
//        if (task.getStatus()==Status.DONE) throw new IllegalEntityStateException("Illegal Object Update",
//                "Status cannot be changed to same state");
//        task.setStatus(Status.DONE); // change the state of the object
//        return Mapper.taskToDTOMaper(taskRepository.saveAndFlush(task)); //returns equivalent dto after persisting the update
//
//    }
//
//    @Override
//    public List<TaskDto> viewAllPending(Long userId) {
//        return taskRepository.findAllPendingTasks(userId).stream()
//                .map(Mapper::taskToDTOMaper)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<TaskDto> viewAllInProgress(Long userId) {
//        return taskRepository.findAllInProgressTasks(userId).stream()
//                .map(Mapper::taskToDTOMaper)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<TaskDto> viewAllDone(Long userId) {
//        return taskRepository.findAllDoneTasks(userId).stream()
//                .map(Mapper::taskToDTOMaper)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<TaskDto> viewAllUserTask(Long userId) {
//        return taskRepository.findAllUserTasks(userId).stream()
//                .map(Mapper::taskToDTOMaper)
//                .collect(Collectors.toList());
//    }
//
//}
