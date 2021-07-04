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
import view.DetailView;
import view.SeatView;

/**
 *
 * @author Lenovo ideapad
 */
public class SeatController extends JFrame implements ActionListener{
    String studio;
    String data[]=new String [4];
    SeatView seatVw;
    SeatModel seatModel;    
    public SeatController(String studio, String[] data,SeatView seatVw, SeatModel seatModel) {
        this.studio = studio;
        this.data = data;                      
        this.seatVw = seatVw;
        this.seatModel = seatModel;
        JButton[] seatVar={
            seatVw.A1,
            seatVw.A2,
            seatVw.A3,
            seatVw.A4,
            seatVw.B1,
            seatVw.B2,
            seatVw.B3,
            seatVw.B4,
            seatVw.C1,
            seatVw.C2,
            seatVw.C3,
            seatVw.C4           
        };
        
        for(JButton button:seatVar){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(studio);                
               String temp[]= seatModel.readSeat(studio, button.getText());
               if(temp[2]==null){
                   System.out.println(studio);
               }else{
                   DetailView detView=new DetailView();
                   detView.setVisible(true);
                   detView.lusername.setText(temp[3]);
                   detView.lstudio.setText(temp[1]);
                   detView.lseat1.setText(temp[0]);
                   detView.btnkembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                                             
                            detView.setVisible(false);
                        }
                    });
               }                              
            }
        });
    }              
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
