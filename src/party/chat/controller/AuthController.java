
package party.chat.controller;

import javax.swing.JOptionPane;
import party.chat.connection.DatabaseConnection;
import party.chat.globals.Globals;
import party.chat.interfaces.IAuth;
import party.chat.screens.ChatScreen;

public class AuthController implements IAuth{
    DatabaseConnection db = new DatabaseConnection();
    @Override
    public boolean login(String email, String password) {
        if(db.isPresent("user", "email", email) == true && db.isPresent("user", "password", password) == true ){
            ChatScreen chatScreen = new ChatScreen();
            chatScreen.setVisible(true);
            Globals.username = email;
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"No record found with this user name and password");
            return false;
        }
        
    }

    @Override
    public boolean register(String email, String password) {
        if (db.isPresent("user", "email", email)) {
            JOptionPane.showMessageDialog(null,"user already exist with this email");
            return false;
        } else {
            db.insert("user", "ID, email, password", (null+",'"+email+"','"+password+"'"));
            Globals.username = email;
            ChatScreen chatScreen = new ChatScreen();
            chatScreen.setVisible(true);
            return true;
        }
    }

    
    
    
}
