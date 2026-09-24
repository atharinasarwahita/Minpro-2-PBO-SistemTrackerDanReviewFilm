package controller;

import java.util.ArrayList;
import models.*;
import view.FilmView;

public class FilmController {
    private ArrayList<Film> daftarFilm = new ArrayList<>();
    private ArrayList<Review> daftarReview = new ArrayList<>();
    private FilmView view = new FilmView();
    
    // Data Dummy untuk menampilkan Film dan Review
    public FilmController() {
        daftarFilm.add(new FeatureFilm(1, "13 Bom di Jakarta", "Angga Dwimas Sasongko", 2023, "Action/Thriller", 144, "Chicco Kurniawan", "Oscar"));
        daftarFilm.add(new AnimatedFilm(2, "Si Juki the Movie", "Faza Meonk", 2017, "Animation/Comedy", 100, "Faza Meonk", "Si Juki", "2D Animation"));

        daftarReview.add(new Review(1, 1, 5.0, "Keren!"));
        }
    
//Create Film
public void tambahFilm() {
    view.tampilkanTambahFilm();
    int jenis = ValidasiInput.inputAngka("Pilih jenis (1/2): ");
    if (jenis < 1 || jenis > 2) {
        System.out.println("Pilihan jenis film tidak valid!");
        return; 
    }
    
    int idFilm = ValidasiInput.inputAngka("Masukkan ID Film: ");
    
    //Validasi ID unik
    for (Film f : daftarFilm) {
        if (f.getIdFilm() == idFilm) {
            System.out.println("ID Sudah Digunakan! Silakan gunakan ID lain.");
            return;
        }
    }
    
    String judul = ValidasiInput.inputTeks("Masukkan Judul Film: ");
    String sutradara = ValidasiInput.inputTeks("Masukkan Sutradara Film: ");
    int tahunRilis = ValidasiInput.inputAngka("Masukkan Tahun Rilis Film: ");
    String genre = ValidasiInput.inputTeks("Masukkan Genre Film: ");
    int durasi = ValidasiInput.inputAngka("Masukkan Durasi Film: ");
    
    switch (jenis) {
        case 1 -> {
            String pemeranUtama = ValidasiInput.inputTeks("Masukkan Nama Aktor Utama: ");
            String karakter = ValidasiInput.inputTeks("Masukkan Nama Karakter/Tokoh: ");
            daftarFilm.add(new FeatureFilm(idFilm, judul, sutradara, tahunRilis, genre, durasi, pemeranUtama, karakter));
        }
        case 2 -> {
            String va = ValidasiInput.inputTeks("Masukkan Nama Voice Actor (VA): ");
            String karakter = ValidasiInput.inputTeks("Masukkan Nama Karakter Animasi: ");
            String gaya = ValidasiInput.inputTeks("Masukkan Gaya Animasi (misal: 2D, 3D CGI): ");
            daftarFilm.add(new AnimatedFilm(idFilm, judul, sutradara, tahunRilis, genre, durasi, va, karakter, gaya));
        }
        default -> {
            System.out.println("Pilihan jenis film tidak valid!");
            return;
        }
    }
    
    System.out.println("\nYeayy, film kamu berhasil ditambahkan!");
    lihatFilm();
}

//Create Review
public void tambahReview() {
    if (daftarFilm.isEmpty()) {
        System.out.println("Belum ada film di sini!");
        return;
    }
            
    lihatFilm();
    view.tampilkanTambahReview();

    int cariFilm;
        while (true) {
            cariFilm = ValidasiInput.inputAngka("Masukkan ID Film yang mau di-review: ");
            boolean adaFilm = false;
            for (Film f : daftarFilm) {
                if (f.getIdFilm() == cariFilm) {
                    adaFilm = true;
                    break;
                }
            }
            if (adaFilm) {
                break;
            } else {
                System.out.println("ID film tidak ada di sistem! Silakan coba lagi.");
            }
        }

    int idReview;
        while (true) {
            idReview = ValidasiInput.inputAngka("Masukkan ID Review: ");
            boolean duplikat = false;
            for (Review r : daftarReview) {
                if (r.getIdReview() == idReview) {
                    duplikat = true;
                    break;
                }
            }
            if (duplikat) {
                System.out.println("ID Sudah Digunakan! Silakan gunakan ID lain.");
            } else {
                break;
            }
        }

        double rating;
        while (true) {
            rating = ValidasiInput.inputRating("Masukkan Rating Film (1 - 5): ");
            Review cekRating = new Review(idReview, cariFilm, 1.0, "dummy");
            if (cekRating.setRating(rating)) {
                break;
            }
        }

        String ulasan = ValidasiInput.inputTeks("Masukkan Ulasan Film: ");
        Review reviewBaru = new Review(idReview, cariFilm, rating, ulasan);
        daftarReview.add(reviewBaru);

        System.out.println("Yeayy, review berhasil ditambahkan!");
        lihatFilm();
    }

//READ (menampilkan film & review dari package view)
public void lihatFilm() {
    view.tampilkanFilm(daftarFilm, daftarReview);
}

//UPDATE REVIEW
public void updateReview() {
    if (daftarReview.isEmpty()) {
        System.out.println("\nBelum ada review yang bisa diubah!");
        return;
    }

    lihatFilm();
    view.tampilkanUpdateReview();
    int updateIdReview = ValidasiInput.inputAngka("Masukkan ID review yang mau di-update: ");

    boolean adaReview = false;
    for (Review r : daftarReview) {
        if (r.getIdReview() == updateIdReview) {
            adaReview = true;
            System.out.println("(1) Rating");
            System.out.println("(2) Ulasan");
            int updateReviewPilihan = ValidasiInput.inputAngka("Pilih ulasan film yang ingin diubah: ");

            switch (updateReviewPilihan) {
                case 1 -> {
                    double ratingBaru;
                    while (true) {
                        ratingBaru = ValidasiInput.inputRating("Rating Film Baru (1 - 5): ");
                        if (r.setRating(ratingBaru)) {
                            break;
                        }
                    }
                    System.out.println("\nYeayy, rating baru kamu berhasil diubah!");
                    lihatFilm();
                    return;
                }

                case 2 -> {
                String ulasanBaru = ValidasiInput.inputTeks("Ulasan Film Baru: ");
                r.setUlasan(ulasanBaru);
                System.out.println("\nYeayy, ulasan terbaru kamu berhasil diubah!");
                lihatFilm();
                return;
                }

                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
    if (!adaReview) {
    System.out.println("ID Review tidak ditemukan!");
    }
}
 
//DELETE REVIEW
public void hapusReview() {
        if (daftarReview.isEmpty()) {
            System.out.println("\nBelum ada review yang bisa dihapus!");
            return;
        }

        lihatFilm();
        view.tampilkanHapusReview();
        int hapusReview = ValidasiInput.inputAngka("Masukkan ID Review yang mau dihapus: ");

        for (Review r : daftarReview) {
            if (r.getIdReview() == hapusReview) {
                boolean konfirmasi = ValidasiInput.inputKonfirmasi("Apakah kamu benar ingin menghapus review ini? (Y/N): ");

                if (konfirmasi){
                    daftarReview.remove(r);
                    System.out.println("\nYeayy, review berhasil dihapus!");
                    lihatFilm();
                } else {
                    System.out.println("Review kamu batal dihapus!");
                }
                return;
            }
        }
        System.out.println("ID Review tidak ditemukan!");
    }
}