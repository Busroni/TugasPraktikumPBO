/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.CustomerModel;
import model.InstalasiDatabase;
import model.SeatModel;
import view.AlertView;
import view.DashboardView;
import view.IndexView;
import view.MovieView;

import view.StudioView;
import view.UserView;

/**
 *
 * @author Lenovo ideapad
 */
public class DashboardController extends JFrame implements ActionListener{
    DashboardView dashVw;

    public DashboardController(DashboardView dashVw) {
        this.dashVw = dashVw;
        dashVw.btnriwayat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                                             
                            dashVw.setVisible(false);
                            UserView csVw=new UserView();
                            csVw.setVisible(true);  
                            CustomerModel cstMod=new CustomerModel();
                            if (cstMod.getBanyakData()!=0) {
                                String dataKontak[][] = cstMod.readUser();
                                csVw.tabel.setModel((new JTable(dataKontak, csVw.namaKolom)).getModel()); //Masih Error
                                
                                csVw.tabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        super.mousePressed(e);
                                        int baris = csVw.tabel.getSelectedRow();                                        
                                        String dataterpilih = csVw.tabel.getValueAt(baris, 0).toString();
                                        System.out.println(dataterpilih);
                                        int temp=Integer.parseInt(dataterpilih);
                                        System.out.print(temp);
                                        if(cstMod.checkUser(temp)){
                                            int input = JOptionPane.showConfirmDialog(null,
                                            "Apa anda ingin menghapus User dengan id" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                                            if (input == 0) {
                                                cstMod.deleteUser(dataterpilih);
                                                String dataKontak[][] = cstMod.readUser();
                                                csVw.tabel.setModel((new JTable(dataKontak, csVw.namaKolom)).getModel()); //Masih Error
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                                            }
                                        }                                        
                                    }
                                });
                                
                                
                                
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            }
                            csVw.getBtnKembali().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {                                          
                                    csVw.setVisible(false);                                                                        
                                    dashVw.setVisible(true);                        
                                }
                            });
                            
                        }
                    });
        dashVw.btnclear.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {   
                            StudioView studio=new StudioView();
                            studio.setVisible(true);
                            SeatModel seatMd=new SeatModel();
                            JButton[] btnStudio={studio.btnstudio1,studio.btnstudio2,studio.btnstudio3};        
                            for(JButton button:btnStudio){
                                button.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) { 
                                        System.out.println(button.getText());
                                        AlertView alert=new AlertView();
                                        alert.setVisible(true);
                                        alert.lalert.setText("Ingin mereset bangku pesanan "+button.getText()+"?");
                                        alert.btnyes.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {                                             
                                                seatMd.clearSeat(button.getText());
                                                alert.setVisible(false);
                                            }
                                        });
                                        alert.btnno.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {                                             
                                                alert.setVisible(false);
                                            }
                                        });
                                        
                                        
                                    }
                                });                             
                            }
                            
                            studio.btnkembali.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {                                          
                                    studio.setVisible(false);
                                    dashVw.setVisible(true);                        
                                }
                            });    
                        }
                    });        
        dashVw.btnmovie.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {                                                                              
                                    dashVw.setVisible(false);
                                    MovieView mvVw=new MovieView();
                                    mvVw.setVisible(true);
                                    MovieController mvCtr=new MovieController(mvVw);
                                }
                            });
        dashVw.btnkembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                                          
                        dashVw.setVisible(false);
                        IndexView indexView=new IndexView();
                        IndexController indexController=new IndexController(indexView);
                        indexView.setVisible(true);                        
                    }
                }); 
        InstalasiDatabase install=new InstalasiDatabase();        
        if(install.checkMovie() && install.checkSeat()){
            dashVw.btninstall.setEnabled(true);
        }else{
            dashVw.btninstall.setEnabled(false);
        }
        dashVw.btninstall.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {                                                                              
                                    
                                    String[] seatVar={
                                        "A1",
                                        "A2",
                                        "A3",
                                        "A4",
                                        "B1",
                                        "B2",
                                        "B3",
                                        "B4",
                                        "C1",
                                        "C2",
                                        "C3",
                                        "C4"           
                                    };
                                    String[] studioVar={
                                        "Studio 1",
                                        "Studio 2",
                                        "Studio 3"
                                    };
                                    for(String studio:studioVar){
                                        install.insertMovie(studio);
                                        for(String seat:seatVar){
                                            install.insertSeat(studio, seat);                                            
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, "Instalasi Berhasil");
                                    dashVw.setVisible(false);
                                    IndexView indexView=new IndexView();
                                    IndexController indexController=new IndexController(indexView);
                                    indexView.setVisible(true);                                       
                                }
                            });             
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
