package ng.companypayroll.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PayrollRepository extends MongoRepository<PayrollRepository, String> {
}
