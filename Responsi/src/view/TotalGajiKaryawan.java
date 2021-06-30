package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orenji
 */
public class TotalGajiKaryawan extends JFrame{
    JLabel lNama = new JLabel("Nama  : ");
    JLabel lUsia = new JLabel("Usia  : ");
    JLabel lGaji = new JLabel("Gaji  : ");  
    JLabel ltot = new JLabel("Total Gaji  : ");      
    
    public JLabel l2Nama = new JLabel();
    public JLabel l2Usia = new JLabel();
    public JLabel l2Gaji = new JLabel();  
    public JLabel l2tot = new JLabel();
          
    JButton btnKembali = new JButton("Kembali");   
    

    public TotalGajiKaryawan() {    
        
        setTitle("Data Karyawan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);       
        
        add(lNama);
        lNama.setBounds(60, 60, 90, 20);
        add(l2Nama);
        l2Nama.setBounds(110, 60, 120, 20);
        
        add(lUsia);
        lUsia.setBounds(60, 100, 90, 20);
        add(l2Usia);
        l2Usia.setBounds(110, 100, 120, 20);
        
        add(lGaji);
        lGaji.setBounds(60, 140, 90, 20);
        add(l2Gaji);
        l2Gaji.setBounds(110, 140, 120, 20);      
        
        add(ltot);
        ltot.setBounds(40, 180, 90, 20);
        add(l2tot);
        l2tot.setBounds(120, 180, 120, 20);  
        
        add(btnKembali);
        btnKembali.setBounds(110, 220, 90, 20);
    }

    public JButton getBtnKembali() {
        return btnKembali;
    }
    
    
}
