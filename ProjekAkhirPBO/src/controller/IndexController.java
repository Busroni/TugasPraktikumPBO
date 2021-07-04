/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DatabaseModel;
import model.RegisterModel;
import view.IndexView;
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
        indexView.setVisible(true);
        indexView.btnlihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                  
                StudioView studioView = new StudioView();                
                StudioController studioController = new StudioController(studioView,null);                                
            }
        });
        indexView.btnpesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                  
                RegisterView registerView = new RegisterView();
                RegisterModel registerModel = new RegisterModel();
                RegisterController regController=new RegisterController(registerView,registerModel);
            }
        });
    }
    
}
