package ng.companypayroll.services;

import lombok.RequiredArgsConstructor;
import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.exceptions.InvalidCredentials;
import ng.companypayroll.exceptions.UserAlreadyExistException;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService  {
    @Autowired
    private UserRepository userRepository;

//    public LoginResponse login(LoginRequest request) throws InvalidCredentials {
//        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("User not found"));
//        if(!user.getPassword().equals(request.getPassword())) {
//            throw new InvalidCredentials("Incorrect  Username or password");
//        }
//        User user = Mapper.map(request);
//        user.setRole(Role.EMPLOYEE);
//        User savedUser = userRepository.save(user);
//        return Mapper.map(savedUser);
//    }

    @Override
    public UserResponse register(UserRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws InvalidCredentials{
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentials("Incorrect Username or password");
        }

        return Mapper.map(request, user);
    }

    @Override
    public String logout() {
        return "Logged out successfully";
    }
}
