package fr.aelion.java.springbootdemo.app.services;

import fr.aelion.java.springbootdemo.app.entities.Project;
import fr.aelion.java.springbootdemo.app.entities.User;
import fr.aelion.java.springbootdemo.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> findAll() {
        // services can do treatments
        // return ((List<User>) this.projectRepo.findAll()).stream().parallel()
        return this.userRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        return this.userRepo.findById(id);
    }

    // Return optional or throws exception
    public List<User> findSomeUser(String term) {
        // return this.userRepo.findByFullTextNativeQuery(search).orElseThrow(...)
        return this.userRepo.search(term);
    }

    public User create(User u) {
        // add some conditions if u need...
        // u.validate() <= system is doing the validation (our constraints annotations)
        return this.userRepo.save(u);
    }
}
