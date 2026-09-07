package ng.companypayroll.dto.auth;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private Double baseSalary;
    private LocalDate hireDate;
}
