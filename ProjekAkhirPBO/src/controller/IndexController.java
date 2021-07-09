/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DatabaseModel;
import model.InstalasiDatabase;
import model.RegisterModel;
import view.DashboardView;
import view.IndexView;
import view.PasswordView;
import view.RegisterView;
import view.StudioView;

/**
 *
 * @author Lenovo ideapad
 */
public class IndexController {
    IndexView indexView;

    public IndexController(IndexView indexView) {
        this.indexView = indexView;
        indexView.setLocationRelativeTo(null);
        indexView.setVisible(true);  
        InstalasiDatabase install=new InstalasiDatabase();        
        if(install.checkMovie() && install.checkSeat()){
            indexView.btnpesan.setEnabled(false);
            indexView.lalert.setText("Lakukan Instalasi Database terlebih dahulu !");
        }else{
            indexView.btnpesan.setEnabled(true);
        }
        indexView.btnpesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                  
                RegisterView registerView = new RegisterView();
                RegisterModel registerModel = new RegisterModel();
                indexView.setVisible(false);
                RegisterController regController=new RegisterController(registerView,registerModel);
            }
        });
        indexView.btnadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                  
                PasswordView pass=new PasswordView();
                pass.setLocationRelativeTo(null);
                pass.setVisible(true);
                indexView.setVisible(false);
                pass.btnkembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                                          
                        pass.setVisible(false);
                        indexView.setLocationRelativeTo(null);
                        indexView.setVisible(true);
                        
                    }
                });  
                pass.btnsubmit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                                          
                        char[] sandi=pass.getTfpass().getPassword();
                        String sandiVal=String.valueOf(sandi);
                        String temp="admin123";
                        System.out.println(sandiVal);
                        if(sandiVal.equals(temp)){
                            DashboardView dash=new DashboardView();
                            dash.setLocationRelativeTo(null);
                            dash.setVisible(true);
                            pass.setVisible(false);
                            DashboardController dashCtr=new DashboardController(dash);
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Sandi yang anda masukan salah");
                        }                        
                    }
                });  
            }
        });       
    }
    
}
