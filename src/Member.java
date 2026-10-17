public class Member {
    // Konstanta aturan validasi (menghindari magic number)
    private static final int MIN_PANJANG_NO_TELP = 10;
    private static final String AWALAN_NO_TELP = "0";

    // Atribut privat untuk enkapsulasi data member
    private String nama;
    private String noTelepon;
    private String tanggalDaftar;
    private String jenisPaket;
}
