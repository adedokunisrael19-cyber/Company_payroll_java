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

        User savedUser = userRepository.save(user);


    }

    @Override
    public UserResponse UpdateUser(UserRequest request) {
        return null;
    }
}

