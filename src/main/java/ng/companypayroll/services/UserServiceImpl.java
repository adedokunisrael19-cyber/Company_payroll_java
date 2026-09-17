package ng.companypayroll.services;
import lombok.RequiredArgsConstructor;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.request.UserUpdateRequest;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.exceptions.UserAlreadyExistException;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        User existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser != null) {
            throw new UserAlreadyExistException("User already exists");
        }

        User user = Mapper.map(request);
        User savedUser = userRepository.save(user);

        return Mapper.map(savedUser);
    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return Mapper.map(user);
    }

    @Override
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        User existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser != null && !existingUser.getId().equals(id)) {
            throw new UserAlreadyExistException("Email already exists");
        }

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User updatedUser = userRepository.save(user);

        return Mapper.map(updatedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(Mapper::map)
                .toList();
    }

    @Override
    public void deleteUser(String Id) {
        User user = userRepository.findById(Id).orElseThrow(() ->
                new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
