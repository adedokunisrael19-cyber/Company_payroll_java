package ng.companypayroll.data.repository;

import ng.companypayroll.data.model.Role;
import ng.companypayroll.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
