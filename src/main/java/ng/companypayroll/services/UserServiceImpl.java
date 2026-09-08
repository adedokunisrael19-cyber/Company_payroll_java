package ng.companypayroll.services;


import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse CreateUser(UserRequest request) {
        User user = new User();

        user.setFullName(request.getFullName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }

    @Override
    public UserResponse UpdateUser(UserRequest request) {
        return null;
    }
}

