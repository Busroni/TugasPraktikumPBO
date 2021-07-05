/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.CustomerModel;
import model.SeatModel;
import view.AlertView;
import view.CustomerView;
import view.DashboardView;
import view.IndexView;
import view.SeatView;
import view.StudioView;

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
                            CustomerView csVw=new CustomerView();
                            csVw.setVisible(true);  
                            CustomerModel cstMod=new CustomerModel();
                            if (cstMod.getBanyakData()!=0) {
                                String dataKontak[][] = cstMod.readUser();
//                                csVw.tabel.setModel((new JTable(dataKontak, csVw.tabel.setModel(dataModel))).getModel()); //Masih Error
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                            }
                            csVw.btnkembali.addActionListener(new ActionListener() {
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
                                    IndexView indexView=new IndexView();
                                    IndexController indexController=new IndexController(indexView);
                                    indexView.setVisible(true);                        
                                }
                            });    
                        }
                    });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
