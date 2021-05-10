package tugaspertemuan5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ruang.Balok;

public class View extends JFrame implements ActionListener{
   private JButton btnHitung;
   private JButton btnReset;

   double panjang;
   double lebar;
   double tinggi;
   JTextField fpanjang;
   JTextField flebar;
   JTextField ftinggi;
   JLabel lvluas;
   JLabel lvkeliling;
   JLabel lvvolume;
   JLabel lvlp;
   
   
    public View(){
	super("Tugas Pertemuan 5");

	JLabel lbl = new JLabel("Kalkulator Balok");
	btnHitung = new JButton("Hitung");
	btnReset = new JButton("Reset");
        
	JLabel lpanjang = new JLabel("Panjang");
    fpanjang = new JTextField(10);
        
    JLabel llebar = new JLabel("Lebar");
    flebar = new JTextField(10);
        
    JLabel ltinggi = new JLabel("Tinggi");
    ftinggi = new JTextField(10);

    JLabel lluas =new JLabel("Luas  ");
	lvluas =new JLabel(":");

    JLabel lkeliling =new JLabel("Keliling  ");
	lvkeliling =new JLabel(":");

    JLabel lvolume =new JLabel("Volume  ");
	lvvolume =new JLabel(":");

	JLabel llp =new JLabel("Luas Permukaan  ");
	lvlp =new JLabel(":");

	btnHitung.addActionListener(this);
	btnReset.addActionListener(this);
	setLayout(null);
	add(lbl);
	add(lpanjang);
	add(fpanjang);
	add(llebar);
	add(flebar);
	add(ltinggi);
	add(ftinggi);
	add(lluas);
	add(lvluas);
	add(lkeliling);
	add(lvkeliling);
	add(lvolume);
	add(lvvolume);
	add(llp);
	add(lvlp);
	add(btnHitung);
	add(btnReset);
    lbl.setBounds(150,5,100,30);
    lpanjang.setBounds(20,80,100,30);
    fpanjang.setBounds(210,80,150,30);
    llebar.setBounds(20,120,100,30);
    flebar.setBounds(210,120,150,30);
    ltinggi.setBounds(20,160,100,30);
    ftinggi.setBounds(210,160,150,30);
    lluas.setBounds(20,200,100,30);
    lvluas.setBounds(210,200,150,30);
    lkeliling.setBounds(20,240,100,30);
    lvkeliling.setBounds(210,240,150,30);
    lvolume.setBounds(20,280,100,30);
    lvvolume.setBounds(210,280,150,30);
    llp.setBounds(20,320,100,30);
    lvlp.setBounds(210,320,150,30);
    btnHitung.setBounds(100,380,100,30);
    btnReset.setBounds(200,380,100,30);



	setSize(400,500);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
;
   }

   public void actionPerformed(ActionEvent e){
	if(e.getSource()==btnHitung){
            if (fpanjang.getText().isEmpty()||flebar.getText().isEmpty()|| ftinggi.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Form masih ada yang kosong");
            }
            else
            {    
                try{              
                    panjang = Double.parseDouble(fpanjang.getText());
                    lebar = Double.parseDouble(flebar.getText());
                    tinggi = Double.parseDouble(ftinggi.getText());   
                    Balok balok=new Balok(tinggi,panjang,lebar);
                    lvluas.setText(Double.toString(balok.hitungLuas()));
                    lvkeliling.setText(Double.toString(balok.hitungKeliling()));
                    lvvolume.setText(Double.toString(balok.menghitungVolume()));
                    lvlp.setText(Double.toString(balok.menghitungLuasPermukaan()));
                }catch(Exception err){
                    JOptionPane.showMessageDialog(this, "Isian tidak boleh berupa String");
                }              
            }
	}
	if(e.getSource()==btnReset){
               fpanjang.setText("");
               flebar.setText("");
               ftinggi.setText("");
               lvluas.setText(":");
               lvkeliling.setText(":");
               lvlp.setText(":");
               lvvolume.setText(":");
	}
   }
    
   public void actionButton(ActionEvent e){
       
       if (fpanjang.getText().isEmpty()||flebar.getText().isEmpty()|| ftinggi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Form masih ada yang kosong");
        }
        else
        {
            
       panjang = Double.parseDouble(fpanjang.getText());
       lebar = Double.parseDouble(flebar.getText());
       tinggi = Double.parseDouble(ftinggi.getText());
       
            
        }
   }

}

