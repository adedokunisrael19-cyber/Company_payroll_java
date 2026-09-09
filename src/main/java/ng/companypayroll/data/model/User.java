package ng.companypayroll.data.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")

public class User {
    @Id
    private String id;
    @NotBlank
    private String fullName;
    @Email
    private String email;
    @NotBlank
    private String password;
    private Role role;
}
