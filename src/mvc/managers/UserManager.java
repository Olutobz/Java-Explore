package mvc.managers;

import mvc.entities.User;

public class UserManager {
    private static final UserManager INSTANCE = new UserManager();

    private UserManager() {
    }

    public static UserManager getInstance() {
        return INSTANCE;
    }

    public User createUser(long id, String email, String password, String firstName,
                           String lastName, String userType, int gender) {

        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserType(userType);
        user.setGender(gender);

        return user;
    }

}