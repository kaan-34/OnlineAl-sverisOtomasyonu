package onlinealisverisotomasyonu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KullaniciService {

    private static final String KULLANICI_FILE_PATH = "kullanicilar.txt";  
   
    public static boolean kayitOl(String kullaniciAdi, String sifre, String rol) {
        List<Kullanici> kullaniciListesi = KullaniciListele();

        
        for (Kullanici k : kullaniciListesi) {
            if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                return false;
            }
        }

       
        Kullanici yeniKullanici = new Kullanici(kullaniciAdi, sifre, rol);
        kullaniciListesi.add(yeniKullanici);

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(KULLANICI_FILE_PATH, true))) {
            writer.write(kullaniciAdi + "," + sifre + "," + rol + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

   
    public static boolean girisYap(String kullaniciAdi, String sifre) {
        List<Kullanici> kullaniciListesi = KullaniciListele();

        for (Kullanici k : kullaniciListesi) {
            if (k.getKullaniciAdi().equals(kullaniciAdi) && k.getSifre().equals(sifre)) {
                return true;
            }
        }

        return false;
    }

    
    static List<Kullanici> KullaniciListele() {
        List<Kullanici> kullaniciListesi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(KULLANICI_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] kullaniciBilgileri = line.split(",");
                String kullaniciAdi = kullaniciBilgileri[0];
                String sifre = kullaniciBilgileri[1];
                String rol = kullaniciBilgileri[2];

                Kullanici kullanici = new Kullanici(kullaniciAdi, sifre, rol);
                kullaniciListesi.add(kullanici);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kullaniciListesi;
    }

    
    public static Kullanici getKullanici(String kullaniciAdi) {
        List<Kullanici> kullaniciListesi = KullaniciListele();
        for (Kullanici k : kullaniciListesi) {
            if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                return k;
            }
        }
        return null;
    }

  
    public static void kullanicilariListele() {
        List<Kullanici> kullaniciListesi = KullaniciListele();
        System.out.println("Kullanıcı Listesi:");
        for (Kullanici k : kullaniciListesi) {
            System.out.println("Kullanıcı Adı: " + k.getKullaniciAdi() + " | Rol: " + k.getRol());
        }
    }

    
    public static boolean kullaniciSil(String kullaniciAdi) {
        List<Kullanici> kullaniciListesi = KullaniciListele();
        Kullanici kullaniciSilinecek = null;
        
       
        for (Kullanici k : kullaniciListesi) {
            if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                kullaniciSilinecek = k;
                break;
            }
        }

        if (kullaniciSilinecek != null) {
            kullaniciListesi.remove(kullaniciSilinecek);

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(KULLANICI_FILE_PATH))) {
                for (Kullanici user : kullaniciListesi) {
                    writer.write(user.getKullaniciAdi() + "," + user.getSifre() + "," + user.getRol() + "\n");
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    
    public static boolean rolDegistir(String kullaniciAdi, String yeniRol) {
        List<Kullanici> kullaniciListesi = KullaniciListele();
        
        
        for (Kullanici k : kullaniciListesi) {
            if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                k.setRol(yeniRol);

               
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(KULLANICI_FILE_PATH))) {
                    for (Kullanici user : kullaniciListesi) {
                        writer.write(user.getKullaniciAdi() + "," + user.getSifre() + "," + user.getRol() + "\n");
                    }
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    
    public static List<Kullanici> getTumKullanicilar() {
        return KullaniciListele(); 
    }
}
