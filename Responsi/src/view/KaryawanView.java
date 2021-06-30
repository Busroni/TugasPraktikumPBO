package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orenji
 */
public class KaryawanView extends JFrame{
    JButton btnLihat = new JButton("Lihat Kontak");
    JButton btnDaftar = new JButton("Tambah Kontak");
    JLabel background = new JLabel();

    public KaryawanView() {
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);
         
//        background.setIcon();
        
        add(btnLihat);
        add(btnDaftar);
        btnDaftar.setBounds(60, 200, 150, 20);
        btnLihat.setBounds(60, 170, 150, 20);
        
        
    }

    public JButton getBtnLihat() {
        return btnLihat;
    }

    public JButton getBtnDaftar() {
        return btnDaftar;
    }
}
