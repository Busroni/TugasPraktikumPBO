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
import view.DetailView;
import view.SeatView;

/**
 *
 * @author Lenovo ideapad
 */
public class SeatController {
    String studio;
    String data[]=new String [4];
    SeatView seatVw;
    SeatModel seatModel;
    String sVar[]={
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
    public SeatController(String studio, String[] data,SeatView seatVw, SeatModel seatModel) {
        this.studio = studio;
        this.data = data;                      
        this.seatVw = seatVw;
        this.seatModel = seatModel;
        JButton seatVar[]={
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
        
        for(int x=0;x<12;x++){
        seatVar[x].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int arr=0;  //Iki salah ki kudune ora ng njero              
               String temp[]= seatModel.readSeat(studio, sVar[arr]);//variabel arr pie carane ben jalan sesuai increment ++
               if(temp[2]==null){
                   System.out.println("next");
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
               arr=arr++;//iki juga percumah sak jan e kudune di deleh njobo
               
            }
        });
    }              
    }}
