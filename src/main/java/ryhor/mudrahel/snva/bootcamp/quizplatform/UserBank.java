package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.Set;

public interface UserBank {

    void store(User user);
    Set<User> getUsers();
}
