package ng.companypayroll.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeRepository, String> {
}
