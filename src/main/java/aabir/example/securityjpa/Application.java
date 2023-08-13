package aabir.example.securityjpa;

import aabir.example.securityjpa.dao.RoleRepository;
import aabir.example.securityjpa.dao.UserRepository;
import aabir.example.securityjpa.entity.Role;
import aabir.example.securityjpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
