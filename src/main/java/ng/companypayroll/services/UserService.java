package ng.companypayroll.services;

import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.request.UserUpdateRequest;
import ng.companypayroll.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse getUserbyId(String Id);
    UserResponse updateUser(String Id, UserUpdateRequest request);
    void deleteUser(String Id);

}
