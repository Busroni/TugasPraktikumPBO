/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

public class RegisterModel {
    DatabaseModel DB=new DatabaseModel();
    public void insertData(String Nama, String Usia, String NoTelp,String Studio,String Seat){        
        try {
                DB.statement = (Statement) DB.koneksi.createStatement();                
                int id=checkId();
                String query = "INSERT INTO `user` (`id`, `nama`, `usia`, `notelp`, `studio`,`seat_code`) VALUES ('"+id+"', '"+Nama+"', '"+Usia+"', '"+NoTelp+"','"+Studio+"','"+Seat+"');";                           
                DB.statement.executeUpdate(query); //execute querynya               
                
                String query2 = "UPDATE `seat` SET `id_customer`='"+id+"' WHERE studio='"+Studio+"' and seat_code='"+Seat+"'";                           
                DB.statement.executeUpdate(query2); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int checkId(){        
        try{
            Random rand = new Random();
            int x = rand.nextInt(1000);                            
            DB.statement = DB.koneksi.createStatement();
            String query = "Select id from user";
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){                                 
                int idTemp=Integer.parseInt(resultSet.getString("id"));
                while(x==idTemp){
                    x=rand.nextInt(1000);
                }                                                
            }    
           return x; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }        
    }   
}


