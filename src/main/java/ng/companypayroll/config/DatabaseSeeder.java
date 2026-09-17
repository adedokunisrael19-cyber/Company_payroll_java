package ng.companypayroll.config;

import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        String adminEmail = "admin@company.com";

        if(userRepository.findByEmail(adminEmail).isEmpty()){
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setPassword("Password123");
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);


            System.out.println("System Admin account successfully seeded.");

        }
    }
}
