package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.HashSet;
import java.util.Set;

public class UserBankImpl implements UserBank {
    private Set<User> users;

    public UserBankImpl() {
        this.users = new HashSet<User>();
    }

    @Override
    public void store(User user) {
        if(!users.contains(user)){
            users.add(user);
            System.out.println("User '"+user.getUsername()+"' added to user list");
        }
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }
}
