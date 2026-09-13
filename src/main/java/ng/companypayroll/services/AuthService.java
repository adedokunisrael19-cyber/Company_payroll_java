package ng.companypayroll.services;

import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.dto.response.UserResponse;

public interface AuthService {
    UserResponse register(UserRequest request);
    LoginResponse login(LoginRequest request);
    String logout();
}
