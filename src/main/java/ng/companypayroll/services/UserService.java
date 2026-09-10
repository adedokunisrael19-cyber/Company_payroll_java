package ng.companypayroll.services;

import ng.companypayroll.data.model.User;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.UserResponse;

public interface UserService {
    UserResponse CreateUser(UserRequest request);
    UserResponse getUserbyId(String Id);
   // UserResponse UpdateUser(UserRequest request);

}
