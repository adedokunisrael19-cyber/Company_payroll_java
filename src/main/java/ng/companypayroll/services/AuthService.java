package ng.companypayroll.services;

import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
