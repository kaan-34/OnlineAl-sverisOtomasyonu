package onlinealisverisotomasyonu;

import java.util.ArrayList;
import java.util.List;

public class UrunListeleme {
    private static List<Urun> urunler = new ArrayList<>();

   
    public UrunListeleme() {
        urunler.add(new Urun(1, "Dambıl Seti", 250));
        urunler.add(new Urun(2, "Yoga Matı", 150));
        urunler.add(new Urun(3, "Kettlebell (12 kg)", 150));
        urunler.add(new Urun(4, "Direnç Bandı Seti", 100));
        urunler.add(new Urun(5, "Koşu Bandı", 3500));
        urunler.add(new Urun(6, "Spor Ayakkabısı (Kadın)", 400));
        urunler.add(new Urun(7, "Spor Ayakkabısı (Erkek)", 400));
        urunler.add(new Urun(8, "Ağırlık Yeleği (5 kg)", 250));
        urunler.add(new Urun(9, "Sırt Çantası", 400));
        urunler.add(new Urun(10, "Egzersiz Topu (65 cm)", 150));
        urunler.add(new Urun(11, "Erkek Spor Atlet", 250));
        urunler.add(new Urun(12, "Kadın Spor Atlet", 250));
        urunler.add(new Urun(13, "1kg Protein Tozu", 1850));
        urunler.add(new Urun(14, "300g Kreatin", 300));
        urunler.add(new Urun(15, "Multivitamin ve Multimineral", 400));
        urunler.add(new Urun(16, "ZMA 90 Kapsül", 500));
    }

    public static void urunEkle(Urun urun) {
        urunler.add(urun);
    }

    public static void urunSil(int urunId) {
        urunler.removeIf(urun -> urun.getId() == urunId);
    }

    public static void urunSil(String urunAd) {
        urunler.removeIf(urun -> urun.getAd().equals(urunAd));
    }

    public static List<Urun> getUrunler() {
        return urunler;
    }

    public static void urunleriGoster() {
        System.out.println("Ürün Listesi:");
        for (Urun urun : urunler) {
            System.out.println("ID: " + urun.getId() + ", Ad: " + urun.getAd() + ", Fiyat: " + urun.getFiyat() + " TL");
        }
    }
}
