package ng.companypayroll.dto.response;

import lombok.Data;
import ng.companypayroll.data.model.Role;

@Data
public class UserResponse {
    private String id;
    private String fullName;
    private String email;
    private Role role;
}
