package ng.companypayroll.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Admin {
    @Id
    private String ID;
    private String fullName;
    private String email;
    private String password;
}
