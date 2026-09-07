package ng.companypayroll.dto.auth;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Data
public class EmployeeResponse {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private double baseSalary;
    private LocalDate hireDate;
}
