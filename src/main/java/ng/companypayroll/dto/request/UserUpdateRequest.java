package ng.companypayroll.dto.request;

import lombok.Data;
import ng.companypayroll.data.model.Role;


@Data
public class UserUpdateRequest {

    private String fullName;
    private String email;
    private String password;
    private Role role;
}
