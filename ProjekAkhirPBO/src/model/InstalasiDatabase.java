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
public class InstalasiDatabase {
    DatabaseModel DB=new DatabaseModel();        
    public void insertSeat(String Studio, String Seat){        
        try {
            String query = "INSERT INTO `seat` (`id_seat`, `studio`, `seat_code`, `id_customer`) VALUES (NULL, '"+Studio+"', '"+Seat+"', '"+0+"');";
           
                DB.statement = (Statement) DB.koneksi.createStatement();
                DB.statement.executeUpdate(query); //execute querynya                
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void insertMovie(String Studio){        
        try {
            String query = "INSERT INTO `movie`(`id`, `nama`, `genre`) VALUES ('"+Studio+"','NULL','NULL')";
           
                DB.statement = (Statement) DB.koneksi.createStatement();
                DB.statement.executeUpdate(query); //execute querynya                
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public boolean checkMovie(){
        int jmlData = 0;
        try{
            DB.statement = DB.koneksi.createStatement();
            String query = "Select * from movie";
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            if(jmlData==0){
                return true;
            }
            else{
                return false;
            }                        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return false;
        }
    }
    public boolean checkSeat(){
        int jmlData = 0;
        try{
            DB.statement = DB.koneksi.createStatement();
            String query = "Select * from seat";
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            if(jmlData==0){
                return true;
            }
            else{
                return false;
            }                        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return false;
        }
    }
}
