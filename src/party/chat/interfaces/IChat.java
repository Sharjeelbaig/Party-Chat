/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package party.chat.interfaces;

import javax.swing.JScrollPane;

/**
 *
 * @author drsha
 */
public interface IChat {
    public void getAllMessages(JScrollPane messageContainer);
    public void sendMessage(String message, JScrollPane messageContainer);
}
