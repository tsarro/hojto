package fi.academy.hojto;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    @Query("SELECT m from Message m  WHERE m.topicId = topicId")
    List<Message> messagesByTopics(@Param("topicId") int topicId);

}
