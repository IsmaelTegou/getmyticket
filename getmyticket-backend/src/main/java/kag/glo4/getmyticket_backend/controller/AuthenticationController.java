package kag.glo4.getmyticket_backend.controller;

import kag.glo4.getmyticket_backend.dto.AuthenticationRequest;
import kag.glo4.getmyticket_backend.dto.AuthenticationResponse;
import kag.glo4.getmyticket_backend.model.User;
import kag.glo4.getmyticket_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }
}
