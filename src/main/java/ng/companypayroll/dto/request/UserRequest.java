package ng.companypayroll.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ng.companypayroll.data.model.Role;

@Data
public class UserRequest {
    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Password required is required")
    private String password;
    @NotNull (message = "Role is required")
    private Role role;
}
