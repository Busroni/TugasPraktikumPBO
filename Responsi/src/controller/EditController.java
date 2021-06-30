/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.InputKaryawan;
import model.KaryawanModel;
import view.KaryawanView;
/**
 *
 * @author Lenovo ideapad
 */
public class EditController{
    InputKaryawan editKaryawan;
    KaryawanModel karyawanModel;

    public EditController(InputKaryawan editKaryawan, KaryawanModel karyawanModel,String id) {
        this.editKaryawan = editKaryawan;
        this.karyawanModel = karyawanModel;    
        String detailKaryawan[]=karyawanModel.detailKaryawan(id);                                
            editKaryawan.tfNama.setText(detailKaryawan[1]);
            editKaryawan.tfUsia.setText(detailKaryawan[2]);
            editKaryawan.tfGaji.setText(detailKaryawan[3]);
        editKaryawan.getBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                karyawanModel.updateData(id,editKaryawan.getNama(),editKaryawan.getTfUsia(),editKaryawan.getTfGaji());   
                KaryawanView StartView=new KaryawanView();
                editKaryawan.setVisible(false);
                KaryawanController Start=new KaryawanController(StartView);
            }
        });
                
    }        
}
