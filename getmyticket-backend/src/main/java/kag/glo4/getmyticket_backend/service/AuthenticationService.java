package kag.glo4.getmyticket_backend.service;

import kag.glo4.getmyticket_backend.dto.AuthenticationRequest;
import kag.glo4.getmyticket_backend.dto.AuthenticationResponse;
import kag.glo4.getmyticket_backend.enums.Role;
import kag.glo4.getmyticket_backend.model.User;
import kag.glo4.getmyticket_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        User user = userRepository.findByEmail(authenticationRequest.getEmail());
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public User registerUser(AuthenticationRequest authenticationRequest) {
        if (userRepository.findByEmail(authenticationRequest.getEmail()) != null) {
            throw new RuntimeException("Email " +authenticationRequest.getEmail()+ " already exists");
        }
        User user = new User();
        user.setEmail(authenticationRequest.getEmail());
        user.setRole(Role.CLIENT);
        user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
        return userRepository.save(user);
    }


}
