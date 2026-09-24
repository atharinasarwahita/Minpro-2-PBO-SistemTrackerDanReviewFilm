package models;

public class AnimatedFilm extends Film {
    private String pengisiSuara;
    private String karakterAnimasi;
    private String gayaAnimasi;

    public AnimatedFilm(int idFilm, String judul, String sutradara, int tahunRilis, String genre, int durasi, String pengisiSuara, String karakterAnimasi, String gayaAnimasi) {
        super(idFilm, judul, sutradara, tahunRilis, genre, durasi);
        this.pengisiSuara = pengisiSuara;
        this.karakterAnimasi = karakterAnimasi;
        this.gayaAnimasi = gayaAnimasi;
    }

    public String getPengisiSuara(){
        return pengisiSuara;
    }

    public String getKarakterAnimasi(){
        return karakterAnimasi;
    }

    public String getGayaAnimasi(){
        return gayaAnimasi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("     Voice     : " + pengisiSuara + " as " + karakterAnimasi);
        System.out.println("     Tipe      : Animated Film (" + gayaAnimasi + ")");
        System.out.println("--------------------------------------------------");
    }
}