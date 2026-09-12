package ng.companypayroll.services;

import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.exceptions.InvalidCredentials;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) throws InvalidCredentials {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));
        if(!user.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentials("Incorrect  Username or password");
        }

        return Mapper.map(user);
    }

}
