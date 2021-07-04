/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ideapad
 */
public class SeatModel {
    DatabaseModel DB=new DatabaseModel();
    public String[] readSeat(String Studio,String Seat){
        try{                        
            String data[]=new String[4];  
            DB.statement = DB.koneksi.createStatement();
            String query = "Select * from seat WHERE studio='"+Studio+"' and seat_code='"+Seat+"'";             
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id_seat"); //harus sesuai nama kolom di mysql
                data[1] = resultSet.getString("studio");                
                data[2] = resultSet.getString("id_customer");                                
            }
            if(data[2]!=null)
            {
                String query2 = "Select * from user WHERE id='"+data[2]+"'";             
                ResultSet resultSet2 = DB.statement.executeQuery(query2);
                while (resultSet2.next()){
                    data[3] = resultSet2.getString("nama"); 
                }
            }
            System.out.println(data[2]);
            return data;                        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void updateSeat(String Nama, String NoHp, String Umur, String Email){
        int jmlData=0;
         try {
           String query = "Select * from contact WHERE NoHp=" + NoHp; 
           ResultSet resultSet = DB.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE contact SET Nama='" + Nama + "', Umur='" + Umur + "', Email='" + Email + "' WHERE NoHp=" + NoHp;
                DB.statement = (Statement) DB.koneksi.createStatement();
                DB.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
