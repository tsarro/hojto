package fi.academy.hojto;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findByTopicId(Topic topicId); //hakee messaget topicId:n perusteella @Olli
<<<<<<< HEAD
    List<Message> findByContentContains(String content);
=======
    List<Message> findByContentContains(String message);
>>>>>>> 00e069148078aaf3c410c654c8ec67c6b205c960
}

