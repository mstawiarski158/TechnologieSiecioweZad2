import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection;


    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }


        Scanner scanner =new Scanner(System.in);
        String input = null ;

        while (!input.equals("5")) {

            System.out.println("Wybierz opcję: \n 1 - Dodaj nowy rekord \n 2 - Wyświetl wszystkie książki \n 3 - Usuwanie \n 4 - Aktualizacja \n 5 - Zakończ ");
            input = scanner.nextLine();

            if (input.equals("1")) {
                LibrarySave saveBook = new LibrarySave();
                saveBook.save(connection);
            }

            if (input.equals("2")) {
                LibraryRead readLibrary = new LibraryRead();
                readLibrary.read(connection);

            }

            if (input.equals("3")) {
                LibraryDelete deleteBook = new LibraryDelete();
                deleteBook.delete(connection);
            }


            if (input.equals("4")) {
                LibraryUpdate updateBook = new LibraryUpdate();
                updateBook.update(connection);
            }

            if (input.equals("4")) {
                LibraryUpdate updateBook = new LibraryUpdate();
                updateBook.update(connection);
            }
        }
        close();

    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}