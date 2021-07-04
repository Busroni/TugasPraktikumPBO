/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ideapad
 */
public class RegisterModel {
    DatabaseModel DB=new DatabaseModel();
    public void insertData(String Nama, String Usia, String NoTelp){
        int jmlData=0;
        try {
            String query = "INSERT INTO `user` (`id`, `nama`, `usia`, `notelp`, `studio_seat`) VALUES (NULL, '"+Nama+"', '"+Usia+"', '"+NoTelp+"', NULL);";
           
                DB.statement = (Statement) DB.koneksi.createStatement();
                DB.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
