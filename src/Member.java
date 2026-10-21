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
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("[DITOLAK] Nama tidak boleh kosong atau hanya berisi spasi");
            return;
        }
        this.nama = nama.trim();
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null
                || !noTelepon.startsWith(AWALAN_NO_TELP)
                || noTelepon.length() < MIN_PANJANG_NO_TELP) {
            System.out.println("[DITOLAK] Nomor telepon harus diawali angka " + AWALAN_NO_TELP
                    + " dan minimal " + MIN_PANJANG_NO_TELP + " digit");
            return;
        }
        this.noTelepon = noTelepon;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        if (tanggalDaftar == null || tanggalDaftar.trim().isEmpty()) {
            System.out.println("[DITOLAK] Tanggal daftar tidak boleh kosong");
            return;
        }
        this.tanggalDaftar = tanggalDaftar.trim();
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }
}
