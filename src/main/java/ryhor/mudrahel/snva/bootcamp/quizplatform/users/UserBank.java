package ryhor.mudrahel.snva.bootcamp.quizplatform.users;

import java.util.Set;

public interface UserBank {

    void store(User user);
    Set<User> getUsers();
}
