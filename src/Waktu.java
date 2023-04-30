package src;

public class Waktu {
    private int hari, jam, menit, detik;

    public Waktu (int hari, int jam, int menit, int detik)
    {
        this.hari = hari;
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }
    public int getDay() {
        return hari;
    }
    public int getJam() {
        return jam;
    }
    public int getMenit() {
        return menit;
    }
    public int getDetik() {
        return detik;
    }
    public void setHari (int hari) {
        this.hari = hari;
    }
    public void setJam (int jam) {
        this.jam = jam;
    }
    public void setMenit (int menit) {
        this.menit = menit;
    }
    public void setDetik (int detik) {
        this.detik = detik;
    }
    public void addDay() {
        hari++;
    }

}
