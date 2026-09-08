package ng.companypayroll.dto.request;

import lombok.Data;
import ng.companypayroll.data.model.Role;

@Data
public class UserRequest {
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
