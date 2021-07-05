/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MovieModel;
import view.DashboardView;
import view.MovieView;

/**
 *
 * @author Lenovo ideapad
 */
public class MovieController {
    MovieView mvVw;

    public MovieController(MovieView mvVw) {
        this.mvVw = mvVw;
        MovieModel mvMd=new MovieModel();
        mvVw.btnkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                          
                mvVw.setVisible(false);    
                DashboardView dashVw = new DashboardView();
                dashVw.setVisible(true);                   
                DashboardController dashCtr = new DashboardController(dashVw);                     
            }
        });
        mvVw.btnsubmit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                          
                String film=mvVw.film1.getText();
                String genre=mvVw.genre1.getText();
                mvMd.updateMovie("Studio 1",film, genre);
            }
        });
        mvVw.btnsubmit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                          
                String film=mvVw.film2.getText();
                String genre=mvVw.genre2.getText();
                mvMd.updateMovie("Studio 2",film, genre);
            }
        });
        mvVw.btnsubmit3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                          
                String film=mvVw.film3.getText();
                String genre=mvVw.genre3.getText();
                mvMd.updateMovie("Studio 3",film, genre);
            }
        });                               
    }
    
    
}
