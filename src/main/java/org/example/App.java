package org.example;

import org.example.mockdatabase.MockDatabase;
import org.example.provider.DataProvider;
import org.example.view.StudentView;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        MockDatabase db = new MockDatabase();
        DataProvider dataProvider = db.getDataProvider();
       // StudentView studentView = new StudentView(dataProvider);
        while(scanner.hasNextLine()) {
            studentView.display();
            if (scanner.nextLine().equals("exit")) {
                break;
            }
        }
    }
}
