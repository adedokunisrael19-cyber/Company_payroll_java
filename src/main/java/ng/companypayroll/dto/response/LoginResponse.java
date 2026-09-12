package ng.companypayroll.dto.response;

import lombok.Data;
import ng.companypayroll.data.model.Role;
import org.springframework.data.annotation.Id;

@Data
public class LoginResponse {
    @Id
    private String Id;
    private String fullName;
    private String email;
    private Role role;

}
