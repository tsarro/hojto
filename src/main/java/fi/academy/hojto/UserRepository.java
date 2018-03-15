package fi.academy.hojto;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import fi.academy.hojto.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}