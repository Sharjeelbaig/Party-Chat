/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package party.chat.interfaces;

/**
 *
 * @author drsha
 */
public interface IAuth {
    boolean login(String username, String password);
    boolean register(String username, String password);
}
