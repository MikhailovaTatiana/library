package test.library.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import test.library.entities.User;
import test.library.repositories.UserRepository;
import test.library.services.UserService;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private UserRepository repo;

    @Override
    public List<User> findAllUsers() {
        return (List<User>) repo.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return repo.findByEmail(email);
    }
}
