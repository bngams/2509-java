package fr.aelion.java.springbootdemo.app.repositories;

import fr.aelion.java.springbootdemo.app.entities.User;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // Can be done with query methods => some example with native query
    @Query(value = """
      SELECT * FROM users
      WHERE LOWER(last_name)   LIKE LOWER(CONCAT('%', :q, '%'))
         OR LOWER(first_name)  LIKE LOWER(CONCAT('%', :q, '%'))
         OR LOWER(email)       LIKE LOWER(CONCAT('%', :q, '%'))
         OR phone_number       LIKE CONCAT('%', :q, '%')
      """, nativeQuery = true)
    List<User> search(@Param("q") String q);
}
