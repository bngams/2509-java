package fr.aelion.java.springbootdemo.app.repositories;

import fr.aelion.java.springbootdemo.app.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
