package sweeter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sweeter.domen.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
