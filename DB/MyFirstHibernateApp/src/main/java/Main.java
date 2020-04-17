import models.Auto;
import models.User;
import services.UserService;

import java.sql.SQLException;

/**
 * Simple Hibernate App Work with DB(PostgreSQL):
 * Object-to-DB, Objects-from-DB
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
    }
}