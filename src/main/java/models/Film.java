package models;

public class Film {
    private int idFilm;
    private String judul;
    private String sutradara;
    private int tahunRilis;
    private String genre;
    private int durasi;
    
    public Film(int idFilm, String judul, String sutradara, int tahunRilis, String genre, int durasi) {
        this.idFilm = idFilm;
        this.judul = judul;
        this.sutradara = sutradara;
        this.tahunRilis = tahunRilis;
        this.genre = genre;
        this.durasi = durasi;
    }
    
    public int getIdFilm() {
        return idFilm;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getSutradara() {
        return sutradara;
    }
    
    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }
    
    public void setTahunRilis(int tahunRilis) {
        this.tahunRilis = tahunRilis;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public int getDurasi() {
        return durasi;
    }
    
    public void tampilkanInfo() {
        System.out.println(" [" + idFilm + "] " + judul + " (" + tahunRilis + ")");
        System.out.println("     Sutradara : " + sutradara);
        System.out.println("     Genre     : " + genre + " | Durasi: " + durasi + " menit");
    }
}
