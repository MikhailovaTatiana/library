package test.library.services;

import test.library.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findUserByEmail(String email);
}
