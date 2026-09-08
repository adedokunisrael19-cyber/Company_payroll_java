package ng.companypayroll.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document
public class Employee {
    @Id
    private String ID;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private int BaseSalary;
    private LocalDate dateOfBirth;
}
