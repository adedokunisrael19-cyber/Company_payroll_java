//package ng.companypayroll.controller;
//
//import ng.companypayroll.dto.request.UserRequest;
//import ng.companypayroll.dto.response.UserResponse;
//import ng.companypayroll.services.UserService;
//import org.junit.jupiter.api.MediaType;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(UserController.class)
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private UserService userService;
//
//    @Test
//    void shouldCreateUser() throws Exception {
//
//        UserResponse response = new UserResponse();
//        response.setId("1");
//        response.setFullName("John Doe");
//        response.setEmail("john@gmail.com");
//
//        when(userService.createUser(any(UserRequest.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                            {
//                                "fullName": "John Doe",
//                                "email": "john@gmail.com",
//                                "password": "1234",
//                                "role": "EMPLOYEE"
//                            }
//                            """))
//                .andExpect(status().isOk());
//
//        verify(userService).createUser(any(UserRequest.class));
//    }
//
//    @Test
//    void shouldCreateUser() throws Exception {
//
//        UserResponse response = new UserResponse();
//        response.setId("1");
//        response.setFullName("John Doe");
//        response.setEmail("john@gmail.com");
//
//        when(userService.createUser(any(UserRequest.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                            {
//                                "fullName": "John Doe",
//                                "email": "john@gmail.com",
//                                "password": "1234",
//                                "role": "EMPLOYEE"
//                            }
//                            """))
//                .andExpect(status().isOk());
//
//        verify(userService).createUser(any(UserRequest.class));
//    }
//
//    @Test
//    void shouldGetUserById() throws Exception {
//
//        UserResponse response = new UserResponse();
//        response.setId("1");
//        response.setFullName("John Doe");
//        response.setEmail("john@gmail.com");
//
//        when(userService.getUserById("1"))
//                .thenReturn(response);
//
//        mockMvc.perform(get("/users/1"))
//                .andExpect(status().isOk());
//
//        verify(userService).getUserById("1");
//    }
//
//    @Test
//    void shouldGetUserById() throws Exception {
//
//        UserResponse response = new UserResponse();
//        response.setId("1");
//        response.setFullName("John Doe");
//        response.setEmail("john@gmail.com");
//
//        when(userService.getUserById("1"))
//                .thenReturn(response);
//
//        mockMvc.perform(get("/users/1"))
//                .andExpect(status().isOk());
//
//        verify(userService).getUserById("1");
//    }
//
//    @Test
//    void shouldGetUserById() throws Exception {
//
//        UserResponse response = new UserResponse();
//        response.setId("1");
//        response.setFullName("John Doe");
//        response.setEmail("john@gmail.com");
//
//        when(userService.getUserById("1"))
//                .thenReturn(response);
//
//        mockMvc.perform(get("/users/1"))
//                .andExpect(status().isOk());
//
//        verify(userService).getUserById("1");
//    }
//
//
//
//
//}