/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.KaryawanModel;
import view.GajiKaryawan;
import view.KaryawanView;
import view.LihatKaryawan;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo ideapad
 */
public class ReadController {
    LihatKaryawan lihatKaryawan;
    KaryawanModel karyawanModel; 

    public ReadController(LihatKaryawan lihatKaryawan, KaryawanModel karyawanModel) {
        this.lihatKaryawan = lihatKaryawan;
        this.karyawanModel = karyawanModel;
        
        if (karyawanModel.getData()!=0) {
            String dataKaryawan[][] = karyawanModel.readKaryawan();
            lihatKaryawan.tabel.setModel((new JTable(dataKaryawan, lihatKaryawan.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        lihatKaryawan.getBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                KaryawanView StartView=new KaryawanView();
                lihatKaryawan.setVisible(false);
                KaryawanController Start=new KaryawanController(StartView);
            }
        });
        
        lihatKaryawan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = lihatKaryawan.tabel.getSelectedRow();                

                String dataterpilih = lihatKaryawan.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                GajiKaryawan dK=new GajiKaryawan();
                lihatKaryawan.setVisible(false);
                DetailController detailController=new DetailController(dK,dataterpilih,karyawanModel);
                                                                            
            }
        }
        );
    }
    
    
    
}
