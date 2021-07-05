/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.IndexController;
import controller.SeatController;
import model.CustomerModel;
import model.MovieModel;
import model.SeatModel;
import view.IndexView;
import view.SeatView;

/**
 *
 * @author Lenovo ideapad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
//        CustomerModel cst=new CustomerModel();
//        cst.checkUser(3214);
//            MovieModel mvMd=new MovieModel();
//            mvMd.setMovie("Studio 1");
//        SeatView setview=new SeatView();
//        setview.setVisible(true);
//        SeatModel setMod=new SeatModel();
//        setMod.clearSeat();
//        String dat[]={"Labdsj0","08","3812931"};
//        SeatController st=new SeatController("Studio 1",dat,setview,setMod);
//      
//        String data[]=setMod.readSeat("ST2","A1");
//        System.out.println(data[3]);
//        StudioModel model=new StudioModel();
        IndexView view=new IndexView();          
        IndexController startView=new IndexController(view);


//        String Studio[]={"Studio 1","Studio 2","Studio 3"};
//        String sVar[]={
//            "A1",
//            "A2",
//            "A3",
//            "A4",
//            "B1",
//            "B2",
//            "B3",
//            "B4",
//            "C1",
//            "C2",
//            "C3",
//            "C4"
//        };
//        SeatInput seat=new SeatInput();
//        
//            for(int y=0;y<24;y++){
//                seat.insertData("Studio 3", sVar[y]);
//            }


    }
    
}
