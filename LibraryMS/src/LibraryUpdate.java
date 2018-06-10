import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUpdate {


    public void update(Connection connection) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id książki którą chcesz uaktualnić:");
        String id = scanner.nextLine();
        System.out.println("Podaj tytuł książki:");
        String title = scanner.nextLine();
        System.out.println("Podaj autora książki:");
        String author = scanner.nextLine();
        System.out.println("Podaj rok wydania książki:");
        Integer year = Integer.valueOf(scanner.nextLine());
        System.out.println("Podaj numer ISBN ksiażki: ");
        String isbn = scanner.nextLine();

        final String sql = "update books set title=?, author=?, bookYear=?, isbn=? where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, title);
            prepStmt.setString(2, author);
            prepStmt.setInt(3, year);
            prepStmt.setString(4, isbn);
            prepStmt.setString(5, id);
            prepStmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Could not update record");
        }

    }
}
