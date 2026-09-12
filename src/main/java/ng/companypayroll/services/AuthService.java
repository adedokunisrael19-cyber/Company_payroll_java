package ng.companypayroll.services;

import ng.companypayroll.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(String email, String password);
}
