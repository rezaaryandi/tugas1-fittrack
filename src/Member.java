/**
 * Merepresentasikan satu member yang terdaftar di gym FitTrack.
 * Class ini menyimpan data pribadi member dan memastikan setiap
 * perubahan data lolos validasi sebelum disimpan.
 */

public class Member {
    // Konstanta aturan validasi (menghindari magic number)
    private static final int MIN_PANJANG_NO_TELP = 10;
    private static final String AWALAN_NO_TELP = "0";

    // Jenis paket yang diperbolehkan
    public static final String PAKET_BASIC = "Basic";
    public static final String PAKET_PREMIUM = "Premium";
    public static final String PAKET_VIP = "VIP";

      // Nilai default untuk data teks yang belum diisi atau tidak valid
    private static final String NILAI_DEFAULT_TEKS = "Belum diisi";

    // Atribut privat untuk enkapsulasi data member
    private String nama = NILAI_DEFAULT_TEKS;
    private String noTelepon = NILAI_DEFAULT_TEKS;
    private String tanggalDaftar = NILAI_DEFAULT_TEKS;
    private String jenisPaket = PAKET_BASIC;

    /**
     * Membuat member baru dengan data lengkap. Setiap nilai diisi lewat
     * setter sehingga data yang tidak valid ditolak dan atributnya tetap
     * memakai nilai default yang aman.
     *
     * @param nama          nama lengkap member, tidak boleh kosong
     * @param noTelepon     nomor telepon, diawali angka 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pertama kali mendaftar, tidak boleh kosong
     * @param jenisPaket    jenis paket: Basic, Premium, atau VIP
     */

    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

    /**
     * Membuat member baru tanpa menentukan paket. Paket otomatis diisi Basic.
     *
     * @param nama          nama lengkap member, tidak boleh kosong
     * @param noTelepon     nomor telepon, diawali angka 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pertama kali mendaftar, tidak boleh kosong
     */

    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, PAKET_BASIC);
    }

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
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            cetakPenolakan("Nama tidak boleh kosong atau hanya berisi spasi");
            return;
        }
        this.nama = nama.trim();
    }

    public void setNoTelepon(String noTelepon) {
        if (!isNoTeleponValid(noTelepon)) {
            cetakPenolakan("Nomor telepon harus berupa angka, diawali angka "
                    + AWALAN_NO_TELP + ", dan minimal " + MIN_PANJANG_NO_TELP + " digit");
            return;
        }
        this.noTelepon = noTelepon;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        if (tanggalDaftar == null || tanggalDaftar.trim().isEmpty()) {
            cetakPenolakan("Tanggal daftar tidak boleh kosong");
            return;
        }
        this.tanggalDaftar = tanggalDaftar.trim();
    }

    public void setJenisPaket(String jenisPaket) {
        if (!isJenisPaketValid(jenisPaket)) {
            cetakPenolakan("Jenis paket harus " + PAKET_BASIC + ", " + PAKET_PREMIUM
                    + ", atau " + PAKET_VIP + " (penulisan persis)");
            return;
        }
        this.jenisPaket = jenisPaket;
    }

    @Override
    public String toString() {
        return "Nama: " + nama
                + " | No. Telepon: " + noTelepon
                + " | Tanggal Daftar: " + tanggalDaftar
                + " | Jenis Paket: " + jenisPaket;
    }

    private static boolean isSemuaAngka(String teks) {
        for (int i = 0; i < teks.length(); i++) {
            if (!Character.isDigit(teks.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNoTeleponValid(String noTelepon) {
        return noTelepon != null
                && noTelepon.startsWith(AWALAN_NO_TELP)
                && noTelepon.length() >= MIN_PANJANG_NO_TELP
                && isSemuaAngka(noTelepon);
    }

    private static boolean isJenisPaketValid(String jenisPaket) {
        return PAKET_BASIC.equals(jenisPaket)
                || PAKET_PREMIUM.equals(jenisPaket)
                || PAKET_VIP.equals(jenisPaket);
    }
    
    private static void cetakPenolakan(String alasan) {
        System.out.println("[DITOLAK] " + alasan);
    }
}
