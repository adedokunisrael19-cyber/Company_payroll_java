package ng.companypayroll.services;

import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import ng.companypayroll.data.repository.UserRepository;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.utils.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Mapper mapper;

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
        UserResponse response = new UserResponse();
        response.setId("1");
        response.setFullName("John Doe");
        response.setEmail("john@gmail.com");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.empty());

        when(Mapper.map(request))
                .thenReturn(user);

        when(userRepository.save(user))
                .thenReturn(user);

        when(Mapper.map(user))
                .thenReturn(response);

        UserResponse result = userService.CreateUser(request);

        assertEquals("1", result.getId());
        assertEquals("John Doe", result.getFullName());
        assertEquals("john@gmail.com", result.getEmail());

        verify(userRepository).save(user);
    }
}