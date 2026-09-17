package ng.companypayroll.controller;

import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.exceptions.InvalidCredentials;
import ng.companypayroll.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    public  AuthController() {

    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws InvalidCredentials {
        return authService.login(request);
    }


}
