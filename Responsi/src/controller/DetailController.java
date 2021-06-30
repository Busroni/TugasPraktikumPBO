/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.KaryawanModel;
import view.GajiKaryawan;
import view.InputKaryawan;
import view.KaryawanView;
import view.TotalGajiKaryawan;

/**
 *
 * @author Lenovo ideapad
 */
public class DetailController {
    GajiKaryawan gajiKaryawan;    
    String id;
    KaryawanModel karyawanModel;
            

    public DetailController(GajiKaryawan gajiKaryawan, String id,KaryawanModel karyawanModel) {
        this.gajiKaryawan = gajiKaryawan;
        this.id = id;
        this.karyawanModel = karyawanModel;
        String detailKaryawan[]=karyawanModel.detailKaryawan(id);
                
                gajiKaryawan.l2Nama.setText(detailKaryawan[1]);
                gajiKaryawan.l2Usia.setText(detailKaryawan[2]);
                gajiKaryawan.l2Gaji.setText(detailKaryawan[3]); 
                
        gajiKaryawan.getBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                KaryawanView StartView=new KaryawanView();
                gajiKaryawan.setVisible(false);
                KaryawanController Start=new KaryawanController(StartView);
            }
        });
        gajiKaryawan.getBtnHapus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data Karyawan dengan ID " + id + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    karyawanModel.deleteKaryawan(id);    
                    KaryawanView StartView=new KaryawanView();
                    gajiKaryawan.setVisible(false);
                    KaryawanController Start=new KaryawanController(StartView);
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        gajiKaryawan.getBtnTotGaji().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                TotalGajiKaryawan detailTotal=new TotalGajiKaryawan();
                gajiKaryawan.setVisible(false);
                detailTotal.l2Nama.setText(detailKaryawan[1]);
                detailTotal.l2Usia.setText(detailKaryawan[2]);
                detailTotal.l2Gaji.setText(detailKaryawan[3]);
                double gaji=Double.parseDouble(detailKaryawan[3]);
                String lembur = gajiKaryawan.getTftot().getText();
                double temp=Double.parseDouble(lembur);
                double total=(temp*25000)+gaji;
                String hasil=Double.toString(total);
                detailTotal.l2tot.setText(hasil); 
                detailTotal.getBtnKembali().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {                               
                        KaryawanView StartView=new KaryawanView();
                        gajiKaryawan.setVisible(false);
                        KaryawanController Start=new KaryawanController(StartView);
                    }
                });
            }
        });
        gajiKaryawan.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                InputKaryawan inputKaryawan=new InputKaryawan();
                gajiKaryawan.setVisible(false);
                EditController editController=new EditController(inputKaryawan,karyawanModel,id);
            }
        });
        
    }

    
        
    
    
}
