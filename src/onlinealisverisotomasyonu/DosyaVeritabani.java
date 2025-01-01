package onlinealisverisotomasyonu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaVeritabani {
    private static final String DOSYA_ADI = "kullanicilar.txt";

    public static void kullaniciEkle(String adSoyad, String email, String sifre, String rol) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOSYA_ADI, true))) {
            writer.write(adSoyad + ";" + email + ";" + sifre + ";" + rol);
            writer.newLine();
        }
    }

    public static List<String[]> kullanicilariOku() throws IOException {
        List<String[]> kullanicilar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DOSYA_ADI))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                kullanicilar.add(satir.split(";"));
            }
        }
        return kullanicilar;
    }

    public static boolean kullaniciDogrula(String email, String sifre) throws IOException {
        List<String[]> kullanicilar = kullanicilariOku();
        for (String[] kullanici : kullanicilar) {
            if (kullanici[1].equals(email) && kullanici[2].equals(sifre)) {
                return true;
            }
        }
        return false;
    }
}
