package ng.companypayroll.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document
public class Payroll {
    @Id
    private String ID;
    private String EmployeeID;
    private String PayPeriod;
    private BigDecimal BasicSalary;
    private BigDecimal Allowances;
    private BigDecimal deductions;
    private LocalDate PaymentDate;
    private PaymentStatus PaymentStatus = ng.companypayroll.data.model.PaymentStatus.ONGOING;
}
