# SISTEM TRACKER DAN REVIEW FILM  

Nama: Atha Rina Sarwahita  
NIM: 2509116047  

---

## 1. Deskripsi Singkat Program
Sistem Tracker Film dan Review ini adalah program yang menangani manajemen pelacakan film dan ulasan. Setiap data memiliki informasi mengenai film, yaitu ID Film, Judul Film, Sutradara, Tahun Rilis, Genre, dan durasi. Sedangkan informasi mengenai review meliputi ID Review, Rating, dan Ulasan.  

Program ini menerapkan konsep dasar Program Berorientasi Objek (PBO) dengan mengelola data film, review user, dan pembaruan review secara real-time dengan emnggunakan ArrayList sebagai media untuk menyimpan data selama program dijalankan.  

---

## 2. Penjelasan Alur Program  
Program ini berjalan melalui terminal dengan alur sebagai berikut:  
1. Entry Point (`Main.java`)
   Program dijalankan melalui method `main()` yang menginisialisasi controller (`FilmController`) beserta data dummy awal, lalu masuk ke dalam perulangan menu utama (`while-loop`).

2. Navigasi Menu Utama
   Terdapat pilihan menu 1 sampai 6 yang dikontrol menggunakan switch.

3. Penerimaan Input & Validasi (`ValidasiInput.java`)
   Setiap kali memasukkan data (angka, teks, rating, konfirmasi Y/N), input dialirkan melalui class ValidasiInput untuk mencegah terjadi error akibat kesalahan tipe data maupun input yang kosong.

4. Eksekusi Fitur Menu Utama (`FilmController.java`)
   - (1) Tambah Film: Controller meminta jenis film (Feature Film atau Animated Film), memeriksa keunikan ID Film, mengumpulkan atribut pendukung, lalu menyimpan objek subclass ke dalam ArrayList<Film>.
   - (2) Tambah Review: Controller memeriksa keberadaan ID Film yang akan di-review, meminta input ID Review unik, memvalidasi rentang rating (1.0 - 5.0), lalu menyimpan objek ke dalam ArrayList<Review>.
   - (3) Lihat Film & Review: Controller memanggil FilmView untuk menampilkan seluruh katalog film beserta ulasan yang relevan berdasarkan kecocokan idFilm.
   - (4) Update Review: Controller mencari objek ulasan berdasarkan idReview, lalu memperbarui nilai rating atau teks ulasan sesuai pilihan pengguna.
   - (5) Hapus Review: Controller meminta konfirmasi (Y/N) via ValidasiInput. Jika dikonfirmasi, ulasan dihapus dari ArrayList<Review>.
   - (6) Keluar: Program menghentikan perulangan dan mengakhiri eksekusi.
  
---

## 3. Penjelasan Penerapan Encapsulation dan Inheritance  

  **A. Encapsulation**  
Encapsulation diterapkan untuk melindungi data internal kelas dari manipulasi langsung dari luar kelas:  
  - Private Attributes: Seluruh atribut pada kelas model (Film, FeatureFilm, AnimatedFilm, dan Review) diatur menggunakan hak akses private.
  - Getter & Setter: Akses ke atribut dilakukan secara terkontrol melalui method getter dan setter.
  - Domain Validation: Pada kelas Review, method setRating(double rating) menerapkan validasi domain internal yang menolak masukan nilai di luar rentang $1.0 - 5.0$ dan mengembalikan nilai boolean untuk memastikan konsistensi data.

  **B. Inheritance**  
Inheritance diterapkan untuk membangun struktur hierarki kelas film guna menghindari duplikasi kode:
- Superclass: Kelas Film bertindak sebagai abstract/parent class yang menampung atribut umum seperti idFilm, judul, sutradara, tahunRilis, genre, dan durasi.
- Subclass:
  - FeatureFilm mewarisi kelas Film dan menambahkan atribut khusus film live-action (pemeranUtama dan karakterLiveAction).
  - AnimatedFilm mewarisi kelas Film dan menambahkan atribut khusus animasi (pengisiSuara, karakterAnimasi, dan gayaAnimasi).
- Penggunaan super() pada konstruktor subclass dipanggil untuk menginisialisasi atribut yang dimiliki oleh superclass Film.

---

## 4. Penjelasan Letak Penerapan Nilai Tambah  

Sistem ini mengimplementasikan dua nilai tambah utama dalam standar pemrograman berorientasi objek:  

  **A. Menerapkan Struktur MVC (Model-View-Controller)**  

```
src/
├── controller/
│   ├── FilmController.java  
│   └── ValidasiInput.java 
├── main/
│   └── Main.java        
├── models/
│   ├── Film.java         
│   ├── FeatureFilm.java   
│   ├── AnimatedFilm.java  
│   └── Review.java      
└── view/
    └── FilmView.java      
```

Penjelasan Peran Layer MVC:  
1. Model (`package model`): Tempat berkumpulnya kelas entitas, seperti Film, FeatureFilm, AnimatedFilm, dan Review. Package ini bertugas menyimpan struktur data, enkapsulasi atribut, dan method validasi nilai rating secara internal.
2. View (`package view`): Di dalam package view terdapat class FilmView. Package ini bertanggung jawab penuh menangani tampilan output (header menu, daftar film dan review). Pada package ini tidak melakukan olah logika data, murni hanya menampilkan data.
3. Controller (`package controller`): Di dalam package view terdapat class FilmController. Package ini bertindak sebagai jembatan yang menghubungkan input pengguna dari ValidasiInput dengan manipulasi ArrayList, lalu meneruskan FilmView untuk ditampilkan.

  **B. Polymorphism (Overriding)**  
     Method tampilkanInfo() pertama kali dideklarasikan pada superclass Film. Method ini kemudian di-override di dalam kelas FeatureFilm dan AnimatedFilm.
     
   Saat tampilkanInfo() dipanggil dalam perulangan ArrayList<Film> di kelas FilmView, Java secara otomatis mengeksekusi versi tampilkanInfo() milik kelas aslinya (FeatureFilm akan mencetak Cast, sedangkan AnimatedFilm akan mencetak Voice Actor dan Gaya Animasi).
