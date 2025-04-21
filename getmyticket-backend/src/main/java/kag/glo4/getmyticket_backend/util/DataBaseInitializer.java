package kag.glo4.getmyticket_backend.util;

import kag.glo4.getmyticket_backend.enums.Role;
import kag.glo4.getmyticket_backend.model.User;
import kag.glo4.getmyticket_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataBaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createTestUser();
    }

    private void createTestUser(){
        User admin = User.builder()
                .email("admin@gmail.com")
                .role(Role.ADMIN)
                .password(passwordEncoder.encode("ADMIN@GMAIL.COM2025")).build();
        User user = User.builder()
                .email("client@gmail.com")
                .role(Role.CLIENT)
                .password(passwordEncoder.encode("CLIENT@GMAIL.COM2025")).build();

        userRepository.save(admin);
        userRepository.save(user);
    }
}
