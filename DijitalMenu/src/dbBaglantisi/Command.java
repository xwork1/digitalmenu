
package dbBaglantisi;
import java.sql.ResultSet;
import java.sql.Statement;


public abstract class Command {
     public abstract void Create(String query);
     public abstract ResultSet Read(Statement con,String query);
     public abstract void Update(String query);
     public abstract void Delete(String query);
}
