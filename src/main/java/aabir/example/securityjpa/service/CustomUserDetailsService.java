package aabir.example.securityjpa.service;

import aabir.example.securityjpa.dao.UserRepository;
import aabir.example.securityjpa.entity.User;
import aabir.example.securityjpa.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Find the user by username in the repository
        Optional<User> userInDb = userRepository.findByUserName(userName);
        userInDb.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));

        // Convert the user entity to CustomUserDetails and return
        return userInDb.map(CustomUserDetails::new).get();
    }
}
