package onlinealisverisotomasyonu;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sepet sepet = new Sepet();
        Kullanici kullanici = null;
        UrunListeleme urunListeleme = new UrunListeleme(); 

        try {
            while (true) {
                System.out.println("Ana Menü:");
                System.out.println("1. Kayıt Ol");
                System.out.println("2. Giriş Yap");
                System.out.println("3. Çıkış");
                System.out.print("Seçiminizi yapın: ");
                int secim = scanner.nextInt();
                scanner.nextLine();  

                if (secim == 1) {
                    System.out.print("Kullanıcı Adı: ");
                    String kullaniciAdi = scanner.nextLine();
                    System.out.print("Şifre: ");
                    String sifre = scanner.nextLine();
                    System.out.print("Rol (Admin/Müşteri): ");
                    String rol = scanner.nextLine();

                    if (KullaniciService.kayitOl(kullaniciAdi, sifre, rol)) {
                        kullanici = new Kullanici(kullaniciAdi, sifre, rol);
                        System.out.println("Kayıt başarılı!");
                    } else {
                        System.out.println("Kullanıcı kaydı başarısız! Bu kullanıcı adı zaten alınmış olabilir.");
                        continue;
                    }
                } else if (secim == 2) {
                    System.out.print("Kullanıcı Adı: ");
                    String kullaniciAdi = scanner.nextLine();
                    System.out.print("Şifre: ");
                    String sifre = scanner.nextLine();

                    if (KullaniciService.girisYap(kullaniciAdi, sifre)) {
                        kullanici = KullaniciService.getKullanici(kullaniciAdi);
                        System.out.println("Giriş başarılı!");
                    } else {
                        System.out.println("Hatalı kullanıcı adı veya şifre! Lütfen tekrar deneyin.");
                        continue;
                    }
                } else if (secim == 3) {
                    System.out.println("Çıkılıyor...");
                    break;
                } else {
                    System.out.println("Geçersiz seçenek.");
                    continue;
                }

               
                UrunListeleme.urunleriGoster();

                while (true) {
                    System.out.print("Ürün numarası seçin (Çıkmak için -1): ");
                    int urunSecim = scanner.nextInt();

                    if (urunSecim == -1) {
                        break;
                    }

                    if (urunSecim < 1 || urunSecim > UrunListeleme.getUrunler().size()) {
                        System.out.println("Geçersiz ürün numarası! Lütfen geçerli bir numara seçin.");
                        continue;
                    }

                    Urun secilenUrun = UrunListeleme.getUrunler().get(urunSecim - 1);
                    sepet.urunEkle(secilenUrun);

                    System.out.println("Ürün sepete eklendi!");
                    System.out.println("Toplam fiyat: " + sepet.toplamFiyat() + " TL");

                    System.out.print("Ana menüye dönmek için '0', ürün eklemeye devam etmek için herhangi bir tuşa basın: ");
                    int menuSecim = scanner.nextInt();
                    if (menuSecim == 0) {
                        break;
                    }
                }

                System.out.println("Ödeme işlemini başlatmak için '1' basın, ana menüye dönmek için '0' basın.");
                int odemeSecim = scanner.nextInt();
                if (odemeSecim == 1) {
                    System.out.println("Ödeme Yöntemi Seçin:");
                    System.out.println("1. Kredi Kartı");
                    System.out.println("2. Banka Kartı");
                    System.out.print("Seçiminizi yapın: ");
                    scanner.nextLine();

                    String kartNumarasi;
                    while (true) {
                        System.out.print("Kart Numarası (16 Haneli): ");
                        kartNumarasi = scanner.nextLine();
                        if (kartNumarasi.length() == 16 && kartNumarasi.matches("[0-9]+")) {
                            break;
                        } else {
                            System.out.println("Geçersiz kart numarası! 16 haneli olmalı ve sadece rakamlardan oluşmalı.");
                        }
                    }

                    String isimSoyisim;
                    while (true) {
                        System.out.print("İsim Soyisim: ");
                        isimSoyisim = scanner.nextLine();
                        if (isimSoyisim.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Geçersiz isim soyisim! Sadece harfler ve boşluk kullanılabilir.");
                        }
                    }

                    String sonKullanimTarihi;
                    while (true) {
                        System.out.print("Son Kullanım Tarihi (MM/YY): ");
                        sonKullanimTarihi = scanner.nextLine();
                        if (sonKullanimTarihi.matches("\\d{2}/\\d{2}")) {
                            break;
                        } else {
                            System.out.println("Geçersiz tarih formatı! Lütfen MM/YY formatında girin.");
                        }
                    }

                    String guvenlikKodu;
                    while (true) {
                        System.out.print("Güvenlik Kodu (CVV - 3 haneli): ");
                        guvenlikKodu = scanner.nextLine();
                        if (guvenlikKodu.length() == 3 && guvenlikKodu.matches("[0-9]+")) {
                            break;
                        } else {
                            System.out.println("Geçersiz güvenlik kodu! 3 haneli olmalı ve sadece rakamlardan oluşmalı.");
                        }
                    }

                    System.out.println("Ödeme başarılı! Sepetinizdeki toplam tutar: " + sepet.toplamFiyat() + " TL");
                    System.out.println("Siparişiniz tamamlandı.");
                    break;
                } else if (odemeSecim == 0) {
                    continue;
                } else {
                    System.out.println("Geçersiz seçim! Ana menüye dönüyoruz.");
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
