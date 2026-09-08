package ng.companypayroll.utils;

import ng.companypayroll.data.model.User;
import ng.companypayroll.dto.request.UserRequest;
import ng.companypayroll.dto.response.UserResponse;

public class Mapper {
    public static User map(UserRequest request){
        User user = new User();

        user.setFullName(request.getFullName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        return user;
    }

    public static UserResponse map(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }
}
