package onlinealisverisotomasyonu;

import java.io.*;


public class SiparisService {
    private static final String SIPARIS_FILE_PATH = "siparisler.txt";  

    
    public static void siparisKaydet(Sepet sepet, Kullanici kullanici) {
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SIPARIS_FILE_PATH, true))) {
            writer.write("Kullanıcı: " + kullanici.getKullaniciAdi() + "\n");
            
            for (SepetUrun sepetUrun : sepet.getSepetUrunler()) {
                writer.write(sepetUrun.getUrun().getAd() + " - " + sepetUrun.getAdet() + " adet - " +
                        sepetUrun.getUrun().getFiyat() * sepetUrun.getAdet() + " TL\n");
            }
            writer.write("Toplam Fiyat: " + sepet.toplamFiyat() + " TL\n");
            writer.write("----\n");
        } catch (IOException e) {
            e.printStackTrace();  
        }
    }

    
    public static void siparisleriGoster(Kullanici kullanici) {
        try (BufferedReader reader = new BufferedReader(new FileReader(SIPARIS_FILE_PATH))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Kullanıcı: " + kullanici.getKullaniciAdi())) {
                    found = true;
                    System.out.println("Sipariş Bilgileri:");
                    System.out.println(line);
                    
                    while ((line = reader.readLine()) != null && !line.equals("----")) {
                        System.out.println(line);
                    }
                }
            }
            if (!found) {
                System.out.println("Geçmiş sipariş bulunamadı.");
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
