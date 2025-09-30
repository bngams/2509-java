package fr.aelion.java.springbootdemo.app.services;

import fr.aelion.java.springbootdemo.app.entities.Project;
import fr.aelion.java.springbootdemo.app.repositories.ProjectRepository;
import fr.aelion.java.springbootdemo.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepo;

    @Autowired
    public ProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Iterable<Project> findAll() {
        // services can do treatments
        // return ((List<Project>) this.projectRepo.findAll()).stream().parallel()
        return this.projectRepo.findAll();
    }

    public Project create(Project p) {
        // add some conditions if u need...
        // p.validate() <= system is doing the validation (our constraints annotations)
        return this.projectRepo.save(p);
    }
}
