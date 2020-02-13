package tableview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager extends Main {

  private Connection con = null;

  public DBManager() throws SQLException {

    this.con =
        DriverManager.getConnection(
            "jdbc:sqlite:C:\\Users\\L0uis\\IdeaProjects\\Iteration1\\src\\Data\\BookStore.db");
    System.out.println("Connected");

  }

  public void insertToAuthor(String name, String email, String url) {
    System.out.println("Db Added");
    try {
      PreparedStatement stmt =
          this.con.prepareStatement(
              "INSERT INTO author (author_name, author_email, author_url) VALUES (?,?,?)");
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setString(3, url);
      stmt.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
