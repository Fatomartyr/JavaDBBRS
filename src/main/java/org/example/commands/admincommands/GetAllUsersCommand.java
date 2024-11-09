package org.example.commands.admincommands;

import org.example.commands.Command;
import org.example.entities.User;
import org.example.provider.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class GetAllUsersCommand implements Command {

    private final DataProvider dataProvider;

    public GetAllUsersCommand(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void execute() {
        try {
            Method method = dataProvider.getUserService().getClass().getDeclaredMethod("getAllUsers");
            @SuppressWarnings("unchecked")
            List<User> users = (List<User>) method.invoke(dataProvider.getUserService());

            if (users.isEmpty()) {
                System.out.println("No users found.");
            }
            else {
                StringBuilder result = new StringBuilder("User List:\n");
                for (User user : users) {
                    result.append(user).append("\n");
                }
                System.out.println(result);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method getAllUsers not found");
        } catch (Exception e) {
            System.out.println("Error retrieving user list");
        }
    }

}
