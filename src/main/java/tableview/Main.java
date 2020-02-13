package tableview;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import org.sqlite.core.DB;

public class  Main {

  public static void main(String[] args) throws IOException, CsvValidationException, SQLException {
    // Literally just calls our parser right now (....and is called for tests)
    CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");
    csvP.printCsv();

    // Load the json
        /*
        1. Create instance of GSON
        2. Create a JsonReader object using FileReader
        3. Array of class instances of AuthorParser, assign data from our JsonReader
        4. foreach loop to check data
         */
    Gson gson = new Gson();
    JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));
    AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);
    DBManager db = new DBManager();
    for (var element : authors) {
      String name = element.getName();
      String email = element.getEmail();
      String url = element.getEmail();

      db.insertToAuthor(name,email,url);
      System.out.println(element.getName());
    }


  }
}
