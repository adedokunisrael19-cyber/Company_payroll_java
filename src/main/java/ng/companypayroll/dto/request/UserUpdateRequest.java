package ng.companypayroll.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ng.companypayroll.data.model.Role;


@Data
public class UserUpdateRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private Role role;
}
