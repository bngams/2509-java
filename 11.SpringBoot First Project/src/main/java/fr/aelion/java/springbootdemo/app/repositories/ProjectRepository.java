package fr.aelion.java.springbootdemo.app.repositories;

import fr.aelion.java.springbootdemo.app.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
