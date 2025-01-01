package onlinealisverisotomasyonu;

import java.util.ArrayList;
import java.util.List;

public class Sepet {
    private List<SepetUrun> sepetUrunler; 

    public Sepet() {
        this.sepetUrunler = new ArrayList<>();
    }

 
    public void urunEkle(Urun urun) {
        for (SepetUrun sepetUrun : sepetUrunler) {
            if (sepetUrun.getUrun().equals(urun)) {
                sepetUrun.setAdet(sepetUrun.getAdet() + 1);
                return;
            }
        }
        sepetUrunler.add(new SepetUrun(urun, 1));  
    }

    
    public void urunSil(Urun urun) {
        sepetUrunler.removeIf(sepetUrun -> sepetUrun.getUrun().equals(urun));
    }

   
    public void urunleriGoster() {
        if (sepetUrunler.isEmpty()) {
            System.out.println("Sepetiniz boş.");
        } else {
            for (SepetUrun sepetUrun : sepetUrunler) {
                System.out.println(sepetUrun); 
            }
        }
    }

   
    public double toplamFiyat() {
        double toplam = 0;
        for (SepetUrun sepetUrun : sepetUrunler) {
            toplam += sepetUrun.getUrun().getFiyat() * sepetUrun.getAdet(); 
        }
        return toplam;
    }

    
    public List<SepetUrun> getSepetUrunler() {
        return sepetUrunler;
    }

   
    public void sepetiTemizle() {
        sepetUrunler.clear();
        System.out.println("Sepetiniz temizlendi.");
    }
}
