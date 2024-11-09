package org.example;

import org.example.entities.Role;
import org.example.mockdatabase.MockDatabase;
import org.example.provider.DataProvider;
import org.example.view.AdminView;
import org.example.view.StudentView;
import org.example.view.UserView;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        MockDatabase db = new MockDatabase();
        DataProvider dataProvider = db.getDataProvider();
        UserView userView = new UserView(dataProvider,scanner);
        userView.display();
        Role role = ApplicationContext.getRole();
        AdminView adminView = new AdminView(dataProvider,scanner);
        StudentView studentView = new StudentView(dataProvider,scanner);
        do {
            if (role.getRoleName().equals("Admin")) {
                adminView.display();
            }
            else if (role.getRoleName().equals("Student")) {
                studentView.display();
            }
        } while (!scanner.nextLine().equals("exit"));
    }
}
