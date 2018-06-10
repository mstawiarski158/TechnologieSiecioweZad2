import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryRead {
    public void read(Connection connection) {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from books";
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                String year = result.getString("yearOfBook");//bookYear
                String isbn = result.getString("isbn");

                System.out.println("nr id: "+id +"\n Title: " + title + "\n Author: " + author+"\n Year: "+year+"\n ISBN: "+isbn+"\n");
            }
        } catch (SQLException e) {
            System.out.println("Can not read DB elements");
        }
    }
}