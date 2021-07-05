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
public class MovieModel {
    DatabaseModel DB=new DatabaseModel();
    public void updateMovie(String studio,String movie,String genre){        
        try {
                DB.statement = (Statement) DB.koneksi.createStatement();                
                String query2 = "UPDATE `movie` SET `nama`='"+movie+"',`genre`='"+genre+"' WHERE `id`='"+studio+"'";                           
                DB.statement.executeUpdate(query2); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Movie pada "+studio+" Berhasil di update");
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public String[] readMovie(){
        try{        
            int jml=0;
            String data[]=new String[getBanyakMovie()];            
            DB.statement = DB.koneksi.createStatement();
            String query = "SELECT `nama` FROM `movie`";             
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){
                data[jml] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql                                
                jml++;
            }            
//            System.out.println(data[2]);
            return data;                        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public int getBanyakMovie(){
        int jmlData = 0;
        try{
            DB.statement = DB.koneksi.createStatement();
            String query = "Select * from movie";
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
    public String[] setMovie(String Studio){
        
        try{           
            String data[]=new String[3];            
            DB.statement = DB.koneksi.createStatement();
            String query = "SELECT * FROM `movie` WHERE id='"+Studio+"'";             
            ResultSet resultSet = DB.statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("nama");
                data[1] = resultSet.getString("genre");//harus sesuai nama kolom di mysql                                                
            }            
//            System.out.println(data[1]);
            return data;      
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
