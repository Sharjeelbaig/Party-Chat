/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package party.chat.interfaces;

import java.util.ArrayList;

/**
 *
 * @author drsha
 */
public interface IDatabaseConnection {
    
public void insert(String table, String columns, String values);    
public String readById(String table, String id, String column);
public Boolean isPresent(String table, String column, String value);
public ArrayList<String> getColumnOfAllRows(String tableName, String column);
}
