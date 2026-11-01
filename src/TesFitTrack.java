/**
 * Program uji untuk class Member. Membuat beberapa member, membuktikan
 * bahwa validasi menolak data salah, lalu mencetak seluruh member.
 */
public class TesFitTrack {
    
    /**
     * Titik masuk program uji FitTrack.
     *
     * @param args argumen command line (tidak dipakai)
     */
    public static void main(String[] args) {
        cetakJudul("1. Membuat objek Member (termasuk satu data tidak valid)");
        Member[] daftarMember = {
                new Member("Alvaro Mahendra", "081234567890", "17-08-2026", Member.PAKET_BASIC),
                new Member("Keisha Azzahra", "085711112222", "18-08-2026", Member.PAKET_PREMIUM),
                new Member("Raka Aditya", "087733334444", "19-08-2026", Member.PAKET_VIP),
                new Member("Nayla Putri", "082155556666", "20-08-2026"),
                new Member("Zidan Firmansyah", "8123456", "21-08-2026", "Platinum")
        };

        cetakJudul("2. Mengubah data member yang sudah jadi dengan nilai tidak valid");
        Member contoh = daftarMember[0];
        System.out.println("Nomor telepon sebelum diubah : " + contoh.getNoTelepon());
        contoh.setNoTelepon("12345");
        System.out.println("Nomor telepon setelah diubah : " + contoh.getNoTelepon());

        cetakJudul("3. Daftar seluruh member");
        for (int i = 0; i < daftarMember.length; i++) {
            System.out.println((i + 1) + ". " + daftarMember[i]);
        }
    }

    private static void cetakJudul(String judul) {
        System.out.println();
        System.out.println("=== " + judul + " ===");
    }
}