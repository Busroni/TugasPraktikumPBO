/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ideapad
 */
public class KaryawanModel {
    String DBurl = "jdbc:mysql://localhost/karyawan";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public KaryawanModel() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    public int getData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from karyawan";
            ResultSet resultSet = statement.executeQuery(query);
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
    
     public String[][] readKaryawan(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getData()][4]; //baris, kolom nya ada 4
            
            String query = "Select * from karyawan"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama");                
                data[jmlData][2] = resultSet.getString("usia");
                data[jmlData][3] = resultSet.getString("gaji");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     public void insertData(String nama, String usia, double gaji){
        int jmlData=0;
        try {
            String query = "INSERT INTO `karyawan`(`nama`, `usia`,`gaji`) VALUES ('"+nama+"','"+usia+"','"+gaji+"')";
            
            statement = koneksi.createStatement();
            statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public String[] detailKaryawan (String id) {
        try{
            String data[] = new String[4];
            String query = "SELECT * FROM karyawan WHERE id = '"+id+"'";            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id"); //harus sesuai nama kolom di mysql
                data[1] = resultSet.getString("nama");                
                data[2] = resultSet.getString("usia");
                data[3] = Double.toString(resultSet.getInt("gaji"));  
            }
            return data;
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     
     public void deleteKaryawan (String id) {
        try{
            String query = "DELETE FROM karyawan WHERE id = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
     
    public void updateData(String id, String nama, String usia, double gaji){        
        try {
            int idKaryawan=Integer.parseInt(id);
            String query = "UPDATE karyawan SET nama='"+nama+"',usia='"+usia+"',gaji='"+gaji+"' WHERE id="+idKaryawan;
            
            statement = koneksi.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Berhasil");
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
