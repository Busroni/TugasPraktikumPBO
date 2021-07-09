/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CustomerModel {
    DatabaseModel DB=new DatabaseModel();    
    public String[][] readUser(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][6]; //baris, kolom nya ada 4
            
            String query = "Select * from user"; 
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama");                
                data[jmlData][2] = resultSet.getString("usia");
                data[jmlData][3] = resultSet.getString("notelp");
                data[jmlData][4] = resultSet.getString("studio");
                data[jmlData][5] = resultSet.getString("seat_code");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public int getBanyakData(){
        int jmlData = 0;
        try{
            DB.statement = DB.koneksi.createStatement();
            String query = "Select * from user";
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public void deleteUser (String id) {
        try{
            String query = "DELETE FROM user WHERE id = '"+id+"'";
            DB.statement = DB.koneksi.createStatement();
            DB.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    public boolean checkUser (int id) {
        try{
            String x = null;              
            String query2 = "Select * from seat WHERE id_customer='"+id+"'";             
            DB.statement = DB.koneksi.createStatement();
            ResultSet resultSet2 = DB.statement.executeQuery(query2);
            while (resultSet2.next()){
                x = resultSet2.getString("id_customer"); 
            }            
            System.out.println(x);
            System.out.print(id);
            if(x!=null){
                JOptionPane.showMessageDialog(null, "User telah memesan tidak dapat dihapus");
                return false;
            }else{
                return true;
            }                        
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
            return false;
        }
        
    }
}


