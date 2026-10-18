public class Member {
    // Konstanta aturan validasi (menghindari magic number)
    private static final int MIN_PANJANG_NO_TELP = 10;
    private static final String AWALAN_NO_TELP = "0";

    // Jenis paket yang diperbolehkan
    public static final String PAKET_BASIC = "Basic";
    public static final String PAKET_PREMIUM = "Premium";
    public static final String PAKET_VIP = "VIP";

    // Atribut privat untuk enkapsulasi data member
    private String nama;
    private String noTelepon;
    private String tanggalDaftar;
    private String jenisPaket;

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }
}
