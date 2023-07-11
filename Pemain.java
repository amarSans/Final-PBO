

public class Pemain {
    private String nama;
    private Arena area;
    private int tengelam;
    public Pemain(String nama, Arena area){
        this.nama=nama;
        this.area=area;
        tengelam=0;
    }
    public String getnama(){
        return nama;
    }
    public int getTengelam(){
        return tengelam;
    }
    public Arena getArea(){
        return area;
    }
    public void KapalTenggelam(){
        tengelam++;
    }
    public boolean saatKalah(int kapal){
        return tengelam==kapal;

    }

}
