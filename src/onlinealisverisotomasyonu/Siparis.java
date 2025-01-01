package onlinealisverisotomasyonu;


public class Siparis {
    private Kullanici kullanici;
    private Sepet sepet;

    public Siparis(Kullanici kullanici, Sepet sepet) {
        this.kullanici = kullanici;
        this.sepet = sepet;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public Sepet getSepet() {
        return sepet;
    }
}
