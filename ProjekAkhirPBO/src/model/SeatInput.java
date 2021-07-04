/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ideapad
 */
public class SeatInput {
    DatabaseModel DB=new DatabaseModel();
    public void insertData(String Studio, String Seat){
        int jmlData=0;
        try {
            String query = "INSERT INTO `seat` (`id_seat`, `studio`, `seat_code`, `id_customer`) VALUES (NULL, '"+Studio+"', '"+Seat+"', NULL);";
           
                DB.statement = (Statement) DB.koneksi.createStatement();
                DB.statement.executeUpdate(query); //execute querynya                
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
