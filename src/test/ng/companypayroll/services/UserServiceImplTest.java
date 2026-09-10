package ng.companypayroll.services;

import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.dto.request.UserUpdateRequest;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ng.companypayroll.exceptions.UserAlreadyExistException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldCreateUser() {

        UserRequest request = new UserRequest();
        request.setFullName("John Doe");
        request.setEmail("john@gmail.com");
        request.setPassword("1234");
        request.setRole(Role.EMPLOYEE);

        User user = new User();
        user.setFullName("John Doe");
        user.setEmail("john@gmail.com");
        user.setPassword("1234");
        user.setRole(Role.EMPLOYEE);

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.empty());


        when(userRepository.save(any(User.class)))
                .thenReturn(user);

        UserResponse result = userService.CreateUser(request);

        assertEquals("John Doe", result.getFullName());
        assertEquals("john@gmail.com", result.getEmail());
    }


    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {

        UserRequest request = new UserRequest();
        request.setEmail("john@gmail.com");

        User existingUser = new User();

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(existingUser));

        assertThrows(
                UserAlreadyExistException.class,
                () -> userService.CreateUser(request)
        );

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void shouldGetUserById() {

        User user = new User();
        user.setFullName("John Doe");
        user.setEmail("john@gmail.com");

        UserResponse response = new UserResponse();
        response.setId("1");
        response.setFullName("John Doe");
        response.setEmail("john@gmail.com");

        when(userRepository.findById("1"))
                .thenReturn(Optional.of(user));

        UserResponse result = userService.getUserbyId("1");

        assertEquals("John Doe", result.getFullName());

    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        when(userRepository.findById("1"))
                .thenReturn(Optional.empty());

        assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserbyId("1")
        );


    }


    @Test
    void shouldUpdateUser() {

        User user = new User();
        user.setId("1");
        user.setFullName("John Doe");
        user.setEmail("john@gmail.com");

        UserUpdateRequest request = new UserUpdateRequest();
        request.setFullName("John Smith");
        request.setEmail("johnsmith@gmail.com");
        request.setPassword("5678");
        request.setRole(Role.EMPLOYEE);

        UserResponse response = new UserResponse();
        response.setId("1");
        response.setFullName("John Smith");
        response.setEmail("johnsmith@gmail.com");

        when(userRepository.findById("1"))
                .thenReturn(Optional.of(user));

        when(userRepository.findByEmail("johnsmith@gmail.com"))
                .thenReturn(Optional.empty());

        when(userRepository.save(user))
                .thenReturn(user);



        UserResponse result = userService.UpdateUser("1", request);

        assertEquals("1", result.getId());
        assertEquals("John Smith", result.getFullName());
        assertEquals("johnsmith@gmail.com", result.getEmail());

        verify(userRepository).save(user);
    }
}