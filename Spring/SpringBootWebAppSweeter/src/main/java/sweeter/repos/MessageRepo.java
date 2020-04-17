package sweeter.repos;

import org.springframework.data.repository.CrudRepository;
import sweeter.domen.Message;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}
