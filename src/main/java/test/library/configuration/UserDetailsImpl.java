package test.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import test.library.entities.User;
import test.library.repositories.UserRepository;
import test.library.services.UserService;

public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserService serv;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = serv.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User could not be found");
        }

        LibraryUserDetails details = new LibraryUserDetails(user);

        return details;
    }
}


