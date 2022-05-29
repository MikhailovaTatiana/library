package test.library.repositories;

import org.springframework.data.repository.CrudRepository;
import test.library.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);
}
