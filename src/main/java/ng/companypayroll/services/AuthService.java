package ng.companypayroll.services;

import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.exceptions.InvalidCredentials;

public interface AuthService {
    LoginResponse login(LoginRequest request) throws InvalidCredentials;
}
