/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import controller.KaryawanController;
import view.GajiKaryawan;
import view.KaryawanView;
import view.InputKaryawan;
import view.LihatKaryawan;
import view.TotalGajiKaryawan;

/**
 *
 * @author Lenovo ideapad
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
//        TotalGajiKaryawan tot=new TotalGajiKaryawan();
//        LihatKaryawan lihatK=new LihatKaryawan();
//          DataKaryawan dat=new DataKaryawan();
        KaryawanView StartView=new KaryawanView();
        KaryawanController Start=new KaryawanController(StartView);
    }
    
}
