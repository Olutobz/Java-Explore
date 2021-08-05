package mvc.dao;

import mvc.database.DataStore;
import mvc.entities.User;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
