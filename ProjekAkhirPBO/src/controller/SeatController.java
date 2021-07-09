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
import model.MovieModel;
import model.RegisterModel;
import model.SeatModel;
import view.AlertView;
import view.DetailView;
import view.SeatView;
import view.StudioView;

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
        
        MovieModel mvMd=new MovieModel();
        seatVw.lstudio.setText(studio);
        String movieData[]=new String[2];
        movieData=mvMd.setMovie(studio);
//        System.out.println(movieData[0]);        
        seatVw.lfilm.setText(movieData[0]);
        seatVw.lgenre.setText(movieData[1]);
        
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
               if(Integer.parseInt(temp[2])==0){
                   System.out.println(temp[2]);
                   AlertView alert=new AlertView();
                   alert.setVisible(true);
                   alert.lalert.setText("Apakah anda akan memilih Bangku "+button.getText());
                   alert.btnyes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                                              
                            RegisterModel regModel = new RegisterModel();                            
                            regModel.insertData(data[1], data[2], data[3], studio, button.getText());
                            alert.setVisible(false);
                        }
                    });
                   alert.btnno.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {                  
                            alert.setVisible(false);
                        }
                    });
                   
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
        seatVw.btnkembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                                          
                        seatVw.setVisible(false);
                        StudioView studioView=new StudioView();
                        StudioController studioController=new StudioController(studioView,data);
                        studioView.setVisible(true);                        
                    }
                });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
