/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.KaryawanModel;
import view.InputKaryawan;
import view.KaryawanView;
import view.LihatKaryawan;



/**
 *
 * @author Lenovo ideapad
 */
public class KaryawanController {
    KaryawanView karyawanView;

    public KaryawanController(KaryawanView kV) {
        this.karyawanView = kV;       
        
        karyawanView.getBtnDaftar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                KaryawanModel karyawanModel = new KaryawanModel();
                InputKaryawan inputKaryawan= new InputKaryawan();
                karyawanView.setVisible(false);
                InputController inputController=new InputController(inputKaryawan,karyawanModel);
            }
        });
        
        karyawanView.getBtnLihat().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                LihatKaryawan lihatKaryawan = new LihatKaryawan();
                KaryawanModel karyawanModel = new KaryawanModel();                
                karyawanView.setVisible(false);
                ReadController readController = new ReadController(lihatKaryawan,karyawanModel);
                
            }
        });
        
        
        
    }
    
}
