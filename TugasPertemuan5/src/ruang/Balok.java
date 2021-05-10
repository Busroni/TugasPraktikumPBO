package ruang;
import bidang.Persegi;
public class Balok extends Persegi implements MenghitungRuang{
    double tinggi;

    public Balok(double tinggi, double panjang, double lebar) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    @Override
    public double menghitungVolume() {
       return hitungLuas()*tinggi;
    }

    @Override
    public double menghitungLuasPermukaan() {
        return hitungLuas()*2+hitungKeliling()*tinggi;
    }
    
    
}
