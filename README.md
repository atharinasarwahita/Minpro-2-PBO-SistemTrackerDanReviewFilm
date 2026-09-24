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
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/92023216-8e15-40f3-b2ad-e71c2565dae8" />

   - (2) Tambah Review: Controller memeriksa keberadaan ID Film yang akan di-review, meminta input ID Review unik, memvalidasi rentang rating (1.0 - 5.0), lalu menyimpan objek ke dalam ArrayList<Review>.
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/9d77a4f6-f075-4f6b-b4ec-68f0314c51e3" />

   - (3) Lihat Film & Review: Controller memanggil FilmView untuk menampilkan seluruh katalog film beserta ulasan yang relevan berdasarkan kecocokan idFilm.
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/a1b4f807-624d-43d2-9de3-7f34437885bb" />

   - (4) Update Review: Controller mencari objek ulasan berdasarkan idReview, lalu memperbarui nilai rating atau teks ulasan sesuai pilihan pengguna.
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/aca1110b-e523-42fa-b3ad-58e79e8a3aab" />

     Menampilkan kembali setelah update
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/545b17b8-5d5c-4c73-9811-678577b15a93" />

   - (5) Hapus Review: Controller meminta konfirmasi (Y/N) via ValidasiInput. Jika dikonfirmasi, ulasan dihapus dari ArrayList<Review>.
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/b001b49e-cc76-42ba-8b4f-9ad20bafe05b" />

     Menampilkan kembali setelah dihapus
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/a4578d9e-eccd-48ae-8cfc-bcd2a15b88eb" />

   - (6) Keluar: Program menghentikan perulangan dan mengakhiri eksekusi.
     
     <img width="800" alt="image" src="https://github.com/user-attachments/assets/183d3d40-da53-45e9-bfa0-b6f5db80430a" />

---

## 3. Penjelasan Penerapan Encapsulation dan Inheritance  

  **A. Encapsulation**  
Encapsulation diterapkan untuk melindungi data internal kelas dari manipulasi langsung dari luar kelas:  
  - Private Attributes: Seluruh atribut pada kelas model (Film, FeatureFilm, AnimatedFilm, dan Review) diatur menggunakan hak akses private.
  - Getter & Setter: Akses ke atribut dilakukan secara terkontrol melalui method getter dan setter.
  - Domain Validation: Pada kelas Review, method setRating(double rating) menerapkan validasi domain internal yang menolak masukan nilai di luar rentang 1.0 - 5.0 dan mengembalikan nilai boolean untuk memastikan konsistensi data.

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
