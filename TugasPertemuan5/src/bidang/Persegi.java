package bidang;

public class Persegi implements MenghitungBidang{
    double panjang;
    double lebar;

    public Persegi(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    @Override
    public double hitungLuas() {
       return panjang*lebar;
    }

    @Override
    public double hitungKeliling() {
       return (panjang*2)+(lebar*2);
    }
    
}
