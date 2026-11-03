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