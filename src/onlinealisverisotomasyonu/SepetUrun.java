package onlinealisverisotomasyonu;

public class SepetUrun {
    private Urun urun;
    private int adet;

    public SepetUrun(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }

    public Urun getUrun() {
        return urun;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public String toString() {
        return urun.getAd() + " - " + adet + " adet - " + urun.getFiyat() * adet + " TL";
    }
}
