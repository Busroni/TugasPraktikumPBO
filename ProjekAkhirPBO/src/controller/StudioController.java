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
import model.SeatModel;
import view.IndexView;
import view.SeatView;
import view.StudioView;

/**
 *
 * @author Lenovo ideapad
 */
public class StudioController extends JFrame implements ActionListener{
    StudioView studioView;
    String data[]=new String[4];       

    public StudioController(StudioView studioView, String[] data) {
        this.studioView = studioView;
        this.data = data;
        System.out.println(data[3]);
        JButton[] btnStudio={studioView.btnstudio1,studioView.btnstudio2,studioView.btnstudio3};
        
        for(JButton button:btnStudio){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {          
                    
                    SeatView seatVw=new SeatView();
                    seatVw.setVisible(true);
                    studioView.setVisible(false);
                    SeatModel seatModel=new SeatModel(); 
                    SeatController seatCtr=new SeatController(button.getText(),data,seatVw,seatModel);                               
                  
                }
            });                             
        }
        studioView.btnkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                          
                studioView.setVisible(false);
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
