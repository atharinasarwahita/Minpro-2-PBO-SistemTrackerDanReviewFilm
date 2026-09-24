package models;

public class FeatureFilm extends Film {
    private String pemeranUtama;
    private String karakterLiveAction;

    public FeatureFilm(int idFilm, String judul, String sutradara, int tahunRilis, String genre, int durasi, String pemeranUtama, String karakterLiveAction) {
        super(idFilm, judul, sutradara, tahunRilis, genre, durasi);
        this.pemeranUtama = pemeranUtama;
        this.karakterLiveAction = karakterLiveAction;
    }
    
    public String getPemeranUtama(){
        return pemeranUtama;
    }

    public String getKarakterLiveAction(){
        return karakterLiveAction;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("     Cast      : " + pemeranUtama + " as " + karakterLiveAction);
        System.out.println("     Tipe      : Feature Film (Live-Action)");
        System.out.println("--------------------------------------------------");
    }
}
