package ng.companypayroll.services;


import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.request.UserUpdateRequest;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.exceptions.UserAlreadyExistException;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new UserAlreadyExistException("User already exist");
        }
        User user = Mapper.map(request);
        User savedUser = userRepository.save(user);

        return  Mapper.map(savedUser);
    }

    @Override
    public UserResponse getUserbyId(String Id) {
        User user = userRepository.findById(Id).orElseThrow(() ->
                new UserNotFoundException("user not found"));
        return Mapper.map(user);
    }

    @Override
    public UserResponse updateUser(String Id, UserUpdateRequest request) {
        User user = userRepository.findById(Id)
                .orElseThrow(() ->
                new UserNotFoundException("User not found"));

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent() && !existingUser.get().getId().equals(Id)) {
            throw new UserAlreadyExistException("Email already exists");
        }

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User updatedUser = userRepository.save(user);

        return Mapper.map(updatedUser);
    }

    @Override
    public void deleteUser(String Id) {
        User user = userRepository.findById(Id).orElseThrow(() ->
                new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }


}

