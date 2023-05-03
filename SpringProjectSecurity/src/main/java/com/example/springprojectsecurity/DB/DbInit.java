/*
package com.example.springprojectsecurity.DB;

import com.example.springprojectsecurity.Model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User dan = new User("liza",passwordEncoder.encode("liza1"),"USER","");
        User admin = new User("miraj",passwordEncoder.encode("miraj1"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("niha",passwordEncoder.encode("niha1"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
*/
