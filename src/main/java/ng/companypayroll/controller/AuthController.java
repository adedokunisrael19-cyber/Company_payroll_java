package ng.companypayroll.controller;

import lombok.NoArgsConstructor;
import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.exceptions.InvalidCredentials;
import ng.companypayroll.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {

    @Autowired
    private  AuthService authService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws InvalidCredentials {
        return authService.login(request);
    }

    @PostMapping("/logout")
    public String logout() {
        return authService.logout();
    }
}
