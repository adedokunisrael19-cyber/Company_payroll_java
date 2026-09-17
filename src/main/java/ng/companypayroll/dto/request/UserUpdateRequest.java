package ng.companypayroll.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ng.companypayroll.data.model.Role;


@Data
public class UserUpdateRequest {
    @NotBlank (message = "full name is required")
    private String fullName;
    @NotBlank
    @Email (message = "Enter a valid email")
    private String email;
    @NotBlank (message = "Password is required")
    private String password;
}
