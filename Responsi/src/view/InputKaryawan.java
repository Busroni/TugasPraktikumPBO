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
public class InputKaryawan extends JFrame{
    JLabel lNama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia");
    JLabel lGaji = new JLabel("Gaji");     
    
    public JTextField tfNama = new JTextField();
    public JTextField tfUsia = new JTextField();
    public JTextField tfGaji = new JTextField();    
   
    
    JButton btnTambah = new JButton("Submit");   
    JButton btnKembali = new JButton("Kembali");   
    JButton btnReset = new JButton("Refresh");

    public InputKaryawan() {    
        
        setTitle("Data Kontak");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);       
        
        add(lNama);
        lNama.setBounds(60, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 60, 120, 20);
        
        add(lUsia);
        lUsia.setBounds(60, 100, 90, 20);
        add(tfUsia);
        tfUsia.setBounds(110, 100, 120, 20);
        
        add(lGaji);
        lGaji.setBounds(60, 140, 90, 20);
        add(tfGaji);
        tfGaji.setBounds(110, 140, 120, 20);
               
        add(btnTambah);
        btnTambah.setBounds(50, 180, 90, 20);
        
        add(btnKembali);
        btnKembali.setBounds(110, 220, 90, 20);
                     
        
        add(btnReset);
        btnReset.setBounds(160, 180, 90, 20);
    }
    
    public String getNama(){
        return tfNama.getText();
    }

    public String getTfUsia() {
        return tfUsia.getText();
    }

    public double getTfGaji() {
        double gaji=Double.parseDouble(tfGaji.getText());                
        return gaji;
    }            

    public JButton getBtnTambah() {
        return btnTambah;
    }

    public JButton getBtnKembali() {
        return btnKembali;
    }   

    public JButton getBtnReset() {
        return btnReset;
    }
    
}
