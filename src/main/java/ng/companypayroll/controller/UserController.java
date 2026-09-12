package ng.companypayroll.controller;

import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.request.UserUpdateRequest;
import ng.companypayroll.dto.response.UserResponse;
import ng.companypayroll.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String Id) {
        return userService.getUserbyId(Id);
    }

    @PutMapping("/{Id}")
    public UserResponse updateUser(@PathVariable String Id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(Id, request);
    }

    @DeleteMapping("/{Id}")
    public void deleteUser(@PathVariable String Id) {
        userService.deleteUser(Id);
    }


}
