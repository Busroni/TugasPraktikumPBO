/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.SeatModel;
import view.SeatView;
import view.StudioView;

/**
 *
 * @author Lenovo ideapad
 */
public class StudioController {
    StudioView studioView;
    String data[]=new String[4];
    String studio[]={"Studio 1","Studio 2","Studio3"};
    

    public StudioController(StudioView studioView, String[] data) {
        this.studioView = studioView;
        this.data = data;
        System.out.println(data[3]);
        studioView.setVisible(true);
        JButton btnStudio[]={studioView.btnstudio1,studioView.btnstudio2,studioView.btnstudio3};
        for(int x=0;x<3;x++){
            btnStudio[x].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {          
                    int arr=0;
                    SeatView seatVw=new SeatView();
                    seatVw.setVisible(true);
                    SeatModel seatModel=new SeatModel(); 
                    SeatController seatCtr=new SeatController(studio[arr],data,seatVw,seatModel);                               
                    arr++;
                }
            });               
        }
        
    }         

}
