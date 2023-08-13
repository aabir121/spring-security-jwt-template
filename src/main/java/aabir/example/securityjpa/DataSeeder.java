package aabir.example.securityjpa;

import aabir.example.securityjpa.dao.RoleRepository;
import aabir.example.securityjpa.dao.UserRepository;
import aabir.example.securityjpa.entity.Role;
import aabir.example.securityjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public DataSeeder(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            Role r1 = new Role(null, "ROLE_USER");
            Role r2 = new Role(null, "ROLE_ADMIN");

            roles.add(r1);
            roles.add(r2);
            roleRepository.saveAllAndFlush(roles);
        }


        Optional<User> user1 = userRepository.findByUserName("user");
        if (user1.isEmpty()) {
            User user = new User(null, "user", "pass", true, Set.of(roles.get(0)));
            userRepository.saveAndFlush(user);
        }

        Optional<User> admin = userRepository.findByUserName("admin");
        if (admin.isEmpty()) {
            User user = new User(null, "admin", "pass", true, Set.of(roles.get(1)));
            userRepository.saveAndFlush(user);
        }
    }
}
