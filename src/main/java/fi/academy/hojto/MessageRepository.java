package fi.academy.hojto;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
