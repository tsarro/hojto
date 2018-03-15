package fi.academy.hojto;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

    Iterable<Topic> findByCategoryId(int id);

    @Modifying
    Optional<Topic> deleteTopicById(int id);
}
