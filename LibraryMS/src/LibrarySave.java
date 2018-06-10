import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySave {

    public void save(Connection connection){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID książki :");
        String id= scanner.nextLine();
        System.out.println("Podaj tytuł książki :");
        String title = scanner.nextLine();
        System.out.println("Podaj autora książki :");
        String author = scanner.nextLine();
        System.out.println("Podaj rok wydania ksiązki:");
        String year =scanner.nextLine();
        System.out.println("Podaj numer ISBN ksiązki:");
        String isbn = scanner.nextLine();

        final String sql = "insert into books(id,title,author,bookYear,isbn) values(?, ?, ?, ?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1,id);
            prepStmt.setString(2, title);
            prepStmt.setString(3, author);
            prepStmt.setString(4, year);
            prepStmt.setString(5, isbn);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }
}

