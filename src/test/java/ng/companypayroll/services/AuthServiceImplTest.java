package ng.companypayroll.services;

import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.LoginRequest;
import ng.companypayroll.dto.response.LoginResponse;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.exceptions.InvalidCredentials;
import ng.companypayroll.exceptions.UserNotFoundException;
import ng.companypayroll.utils.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    public void testThatUserShouldBeAbleToLogin() throws InvalidCredentials {
        User user = new User();
        user.setId("1");
        user.setFullName("John Doe");
        user.setEmail("john@gmail.com");
        user.setPassword("1234");
        user.setRole(Role.EMPLOYEE);

        LoginRequest request = new LoginRequest();
        request.setEmail("john@gmail.com");
        request.setPassword("1234");

        LoginResponse response = new LoginResponse();
        response.setId("1");
        response.setFullName("John Doe");
        response.setEmail("john@gmail.com");
        response.setRole(Role.EMPLOYEE);

        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));

        LoginResponse result = authService.login(request);

        assertEquals("1", result.getId());
        assertEquals("John Doe", result.getFullName());
        assertEquals(Role.EMPLOYEE, result.getRole());

    }

    @Test
    public void ExceptionShouldbeThrownwhenUserDoesNotExist(){
      LoginRequest request = new LoginRequest();

      request.setEmail("JohnDoe@gmail.com");
      request.setPassword("1234");

      when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());

      assertThrows(UserNotFoundException    .class, () -> authService.login(request));
    }


    @Test
    public void ExceptionShouldbeThrownwhenPasswordDoesNotMatch(){
        User user = new User();
        user.setId("1");
        user.setEmail("john@gmail.com");
        user.setPassword("1234");

        LoginRequest request = new LoginRequest();
        request.setEmail("john@gmail.com");
        request.setPassword("wrong");

        assertThrows(UserNotFoundException.class, ()-> authService.login(request));

    }

}