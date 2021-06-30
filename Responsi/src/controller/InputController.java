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

/**
 *
 * @author Lenovo ideapad
 */
public class InputController {
    InputKaryawan inputKaryawan;
    KaryawanModel karyawanModel;

    public InputController(InputKaryawan inputKaryawan, KaryawanModel karyawanModel) {
        this.inputKaryawan = inputKaryawan;
        this.karyawanModel = karyawanModel;
        
        inputKaryawan.getBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                KaryawanView StartView=new KaryawanView();
                inputKaryawan.setVisible(false);
                KaryawanController Start=new KaryawanController(StartView);
            }
        });
        inputKaryawan.getBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                karyawanModel.insertData(inputKaryawan.getNama(),inputKaryawan.getTfUsia(),inputKaryawan.getTfGaji());   
                KaryawanView StartView=new KaryawanView();
                inputKaryawan.setVisible(false);
                KaryawanController Start=new KaryawanController(StartView);
            }
        });
        inputKaryawan.getBtnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                inputKaryawan.tfNama.setText("");
                inputKaryawan.tfUsia.setText("");
                inputKaryawan.tfGaji.setText("");
            }
        });
    }
    
    
}
