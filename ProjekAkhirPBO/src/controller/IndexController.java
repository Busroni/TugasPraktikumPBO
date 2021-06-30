/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.StudioModel;
import view.IndexView;
import view.StudioView;

/**
 *
 * @author Lenovo ideapad
 */
public class IndexController {
    IndexView indexView;

    public IndexController(IndexView indexView) {
        this.indexView = indexView;
        
        indexView.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudioView studioView = new StudioView();
                StudioModel studioModel = new StudioModel();
                StudioController studioController = new StudioController();
                
                
            }
        });
    }
    
}
