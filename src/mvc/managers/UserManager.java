package mvc.managers;

import mvc.dao.UserDao;
import mvc.entities.User;

public class UserManager {
    private static final UserManager INSTANCE = new UserManager();
    private static UserDao userDao = new UserDao();

    private UserManager() {
    }

    public static UserManager getInstance() {
        return INSTANCE;
    }

    public User[] getUsers() {
        return userDao.getUsers();
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