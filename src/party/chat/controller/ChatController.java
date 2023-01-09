/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package party.chat.controller;

import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import party.chat.connection.DatabaseConnection;
import party.chat.globals.Globals;

/**
 *
 * @author drsha
 */
public class ChatController {
    DatabaseConnection db = new DatabaseConnection();
    public void getAllMessages(JScrollPane messageContainer){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ArrayList<String> sender = db.getColumnOfAllRows("messages", "sender");
        ArrayList<String> message = db.getColumnOfAllRows("messages", "message");
        for (int i = 0; i < message.size(); i++) {
        panel.add(new JLabel("<html><br>"+sender.get(i)+":- "+message.get(i)+"</html>"));
        messageContainer.setViewportView(panel);
        }
    }
    public void sendMessage(String message, JScrollPane messageContainer){
        db.insert("messages","ID, message, sender", (null+",'"+message+"','"+Globals.username+"'"));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("<html><br>"+Globals.username+":- "+message+"</html>"));
        messageContainer.setViewportView(panel);
        getAllMessages(messageContainer);
    }
}
