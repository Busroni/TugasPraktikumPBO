/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.RegisterModel;
import view.IndexView;
import view.RegisterView;
import view.StudioView;

/**
 *
 * @author Lenovo ideapad
 */
class RegisterController {
    RegisterView regView;
    RegisterModel regModel;

    public RegisterController(RegisterView regView, RegisterModel regModel) {
        this.regView = regView;
        this.regModel = regModel;
        regView.setLocationRelativeTo(null);
        regView.setVisible(true);
        regView.btnpilih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String user[]=new String[4];
                user[1]=regView.tfnama.getText();
                user[2]=regView.tfusia.getText();
                user[3]=regView.tfno.getText();    
                System.out.println(user[3]);
                if(user[1].equals("") || user[2].equals("") || user[3].equals("")){
                    regView.setVisible(false);
                        IndexView indexView=new IndexView();
                        IndexController indexController=new IndexController(indexView);
                        indexView.setLocationRelativeTo(null);
                        indexView.setVisible(true);
                }else{
                    StudioView stView=new StudioView();
                    stView.setLocationRelativeTo(null);
                    stView.setVisible(true);
                    regView.setVisible(false);
                    StudioController stCtr=new StudioController(stView,user);   
                }                
            }
        });
        regView.btnkembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                                          
                        regView.setVisible(false);
                        IndexView indexView=new IndexView();
                        IndexController indexController=new IndexController(indexView);
                        indexView.setLocationRelativeTo(null);
                        indexView.setVisible(true);                        
                    }
                });  
    }
    
}
