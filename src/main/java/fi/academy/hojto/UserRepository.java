package fi.academy.hojto;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import fi.academy.hojto.User;

public interface UserRepository extends CrudRepository<User, Long> {


}