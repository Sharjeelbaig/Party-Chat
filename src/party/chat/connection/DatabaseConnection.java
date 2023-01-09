package party.chat.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import party.chat.interfaces.IDatabaseConnection;

public class DatabaseConnection implements IDatabaseConnection {
    public Connection connection;
    //Constructor to Connect Our database
    public DatabaseConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+System.getProperty("user.dir") + "\\src\\party\\chat\\connection\\db.accdb");
            connection = conn;
            } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    //Putting Something to database
    @Override
    public  void insert(String table, String columns, String values){
        try {
            Statement cs = connection.createStatement();
            cs.executeUpdate("insert into " + table + " ("+columns+") " + " values ("+values+")" );
            } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    //Reading from the database by specific id
    public String readById(String table, String id, String column){
        try {
            Statement cs = connection.createStatement();
            ResultSet rs = cs.executeQuery("Select * From "+table+" where ID="+id);
            return rs.getString(column);
            } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
           }
           }
    //reading specific coulumn
    @Override
    public Boolean isPresent(String table, String column, String value) {
        try {
            Statement cs = connection.createStatement();
            ResultSet rs = cs.executeQuery("SELECT * FROM "+table+" where "+column+"='"+value+"'");
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
           }
           }
    //get all rows in a table
    public ArrayList<String> getColumnOfAllRows(String tableName, String column){
        ArrayList<String> allColumns = new ArrayList<String>();
        try {
            //SELECT COUNT(*) FROM table_name;
            Statement cs = connection.createStatement();
            ResultSet rs = cs.executeQuery("SELECT * FROM "+tableName);
                    
            while (rs.next()) {
            String columnText = rs.getString(column);
            allColumns.add(columnText);
            
      }
            return allColumns;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
}
