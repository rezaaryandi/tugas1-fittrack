# Tugas 1: Sistem Keanggotaan Gym FitTrack

- **Nama lengkap:** (Muhammad Reza Aryandi)
- **NPM:** (250810701100015)
- **Kelas praktikum:** (Praktikum Pemrograman Beriontesi Object A )
- **Mata kuliah:** Praktikum Pemrograman Berorientasi Objek (Remedial UTS / Tugas 1)

## Deskripsi Singkat

FitTrack adalah gym kecil dengan sekitar 150 member aktif yang selama ini mencatat data member di buku tulis, sehingga data mudah hilang, sulit dibaca, dan lambat dicari. Program ini adalah langkah awal digitalisasi: sistem pendataan member berbasis Java yang berjalan di satu komputer dan memastikan data yang masuk selalu valid, terutama nomor telepon.

## Fitur Utama

- Mencatat member baru lengkap dengan nama, nomor telepon, tanggal daftar, dan jenis paket.
- Mendaftarkan member tanpa memilih paket; paketnya otomatis Basic.
- Menolak data yang salah dan menampilkan alasan penolakan yang jelas, misalnya nomor telepon yang tidak diawali 0.
- Mempertahankan data lama ketika perubahan data ditolak.
- Tetap membuat data member dengan nilai default yang aman walaupun ada isian yang salah, sehingga pendaftaran tidak terhenti.
- Menampilkan seluruh daftar member dalam format yang rapi dan berlabel.

## Konsep OOP yang Diterapkan

| Konsep | Lokasi penerapan | Alasan |
|---|---|---|
| Class dan object | `Member`, `TesFitTrack` | `Member` memodelkan satu member nyata. `TesFitTrack` memisahkan kode uji dari kode model. |
| Encapsulation | Atribut `private` dan getter/setter di `Member` | Data hanya bisa diubah lewat setter sehingga selalu melewati validasi. |
| Constructor | `Member(nama, noTelepon, tanggalDaftar, jenisPaket)` | Mengisi semua atribut saat objek dibuat, lewat setter, sehingga validasi tidak ditulis ulang. |
| Constructor overloading dan `this(...)` | `Member(nama, noTelepon, tanggalDaftar)` | Versi tanpa paket memanggil constructor lengkap dengan Basic, jadi tidak ada kode yang diulang. |
| Kata kunci `this` | Setter dan constructor di `Member` | Membedakan atribut objek dari parameter yang namanya sama. |
| Overriding | `toString()` di `Member` | Objek tercetak berlabel, bukan alamat memori bawaan Java. |
| Array dan perulangan `for` | `TesFitTrack.main` | Beberapa objek `Member` disimpan dalam satu array lalu dicetak satu per satu. |
| Konstanta (`static final`) | `Member`: `MIN_PANJANG_NO_TELP`, `AWALAN_NO_TELP`, `PAKET_BASIC`, `PAKET_PREMIUM`, `PAKET_VIP`, `NILAI_DEFAULT_TEKS` | Batas validasi dan nama paket diberi nama sehingga tidak ada magic number atau magic string. |
| Method private pembantu | `isNoTeleponValid`, `isSemuaAngka`, `isJenisPaketValid`, `cetakPenolakan` | Satu method satu tanggung jawab, dan pencetakan pesan penolakan tidak diulang di tiap setter. |

## Struktur Project

```
tugas1-fittrack/
├── src/
│   ├── Member.java
│   └── TesFitTrack.java
├── screenshot/
│   └── output.png
├── .gitignore
└── README.md
```
## Prasyarat

- JDK 17 atau lebih baru (dikembangkan dan diuji dengan JDK 21).
- IDE yang disarankan: IntelliJ IDEA.

## Cara Menjalankan Program

**Lewat IntelliJ IDEA**

1. Buka folder `tugas1-fittrack` lewat *File > Open*.
2. Tandai folder `src` sebagai *Sources Root* (klik kanan > *Mark Directory as* > *Sources Root*).
3. Buka `TesFitTrack.java`, lalu klik tombol Run di samping method `main`.

**Lewat command line** (dari folder `tugas1-fittrack`)

```
javac -d out src/*.java
java -cp out TesFitTrack
```

## Contoh Output

> Tempelkan screenshot hasil eksekusi di sini (skenario normal dan skenario validasi menolak data), misalnya `![Output](screenshot/output.png)`.

Output teks sebagai referensi:

```

=== 1. Membuat objek Member (termasuk satu data tidak valid) ===
[DITOLAK] Nomor telepon harus berupa angka, diawali angka 0, dan minimal 10 digit
[DITOLAK] Jenis paket harus Basic, Premium, atau VIP (penulisan persis), paket tetap Basic

=== 2. Mengubah data member yang sudah jadi dengan nilai tidak valid ===
Nomor telepon sebelum diubah : 081234567890
[DITOLAK] Nomor telepon harus berupa angka, diawali angka 0, dan minimal 10 digit
Nomor telepon setelah diubah : 081234567890

=== 3. Daftar seluruh member ===
1. Nama: Budi Santoso | No. Telepon: 081234567890 | Tanggal Daftar: 17-08-2026 | Jenis Paket: Basic
2. Nama: Siti Rahma | No. Telepon: 085711112222 | Tanggal Daftar: 18-08-2026 | Jenis Paket: Premium
3. Nama: Andi Pratama | No. Telepon: 087733334444 | Tanggal Daftar: 19-08-2026 | Jenis Paket: VIP
4. Nama: Dewi Lestari | No. Telepon: 082155556666 | Tanggal Daftar: 20-08-2026 | Jenis Paket: Basic
5. Nama: Rina Wulandari | No. Telepon: Belum diisi | Tanggal Daftar: 21-08-2026 | Jenis Paket: Basic
```

Penjelasan: pada bagian 1, member kelima ditolak nomor teleponnya dan paketnya sekaligus. Pada bagian 2, `setNoTelepon("12345")` ditolak dan nomor lama tetap bertahan.

## Nilai Default

Nilai default dipakai ketika data yang dikirim tidak valid saat objek dibuat. Nilai ini ditetapkan sebagai nilai awal atribut, sehingga setter yang menolak input otomatis meninggalkan atribut pada nilai tersebut.

| Atribut | Nilai default | Alasan |
|---|---|---|
| `nama` | `Belum diisi` | Penanda jelas bahwa data belum terisi, mudah dikenali staf, dan tidak menyerupai nama asli. |
| `noTelepon` | `Belum diisi` | Nomor "asal" seperti `0000000000` bisa lolos validasi dan keliru dianggap nomor sungguhan. Penanda teks tidak akan pernah lolos validasi, sehingga mudah dicari untuk dilengkapi. |
| `tanggalDaftar` | `Belum diisi` | Menebak tanggal berisiko salah. Lebih aman ditandai belum terisi. |
| `jenisPaket` | `Basic` | Sesuai aturan soal: paket paling dasar, dan paling aman karena tidak memberi fasilitas lebih dari yang dibayar. |

Aturan tambahan yang saya pilih sendiri: nomor telepon harus berupa angka saja, dan tanggal daftar tidak boleh kosong (format tetap bebas).

## Batasan dan Pengembangan Lanjutan

- Data hanya disimpan selama program berjalan dan hilang saat program ditutup. Tahap berikutnya bisa menyimpan ke file atau database.
- Belum ada menu interaktif; skenario masih dijalankan lewat `TesFitTrack`.
- Tanggal daftar masih berupa `String` tanpa pengecekan format. Bisa diganti `LocalDate`.
- Belum ada pengecekan nomor telepon ganda dan belum ada fitur mencari member berdasarkan nama.
- Pesan penolakan belum menyebut member mana yang datanya ditolak. Bisa ditambah di pengembangan lanjutan.