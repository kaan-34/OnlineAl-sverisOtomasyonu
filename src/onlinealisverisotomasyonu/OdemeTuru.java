package onlinealisverisotomasyonu;

public class OdemeTuru {
    private String tur; 
    private String kartNumarasi; 
    private String isimSoyisim; 
    private String sonKullanmaTarihi; 
    private String guvenlikKodu; 

    
    public OdemeTuru(String tur, String kartNumarasi, String isimSoyisim, String sonKullanmaTarihi, String guvenlikKodu) {
        this.tur = tur;
        this.kartNumarasi = kartNumarasi;
        this.isimSoyisim = isimSoyisim;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.guvenlikKodu = guvenlikKodu;
    }

    
    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public String getGuvenlikKodu() {
        return guvenlikKodu;
    }

    public void setGuvenlikKodu(String guvenlikKodu) {
        this.guvenlikKodu = guvenlikKodu;
    }

    
    @Override
    public String toString() {
        return "Ödeme Türü: " + tur + "\nKart Numarası: " + kartNumarasi + "\nİsim Soyisim: " + isimSoyisim + 
               "\nSon Kullanma Tarihi: " + sonKullanmaTarihi + "\nGüvenlik Kodu: " + guvenlikKodu;
    }
}
