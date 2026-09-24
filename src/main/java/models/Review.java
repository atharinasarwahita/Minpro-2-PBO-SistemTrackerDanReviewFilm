package models;

public class Review {
    private int idReview;
    private int idFilm;
    private double rating;
    private String ulasan;
    
    //Constructor
    public Review(int idReview, int idFilm, double rating, String ulasan) {
        this.idReview = idReview;
        this.idFilm = idFilm;
        setRating(rating);
        this.ulasan = ulasan;
    }
        
    public int getIdReview() {
        return idReview; 
    }
    
    public int getIdFilm() {
        return idFilm;
    }
    
    public String getUlasan() {
        return ulasan; 
    }
    
    public double getRating() {
        return rating; 
    }
    
    public boolean setRating(double rating) {
    if (rating >= 1.0 && rating <= 5.0) {
        this.rating = rating;
        return true;
    } else {
        System.out.println("Gagal! Rating harus antara 1.0 sampai 5.0!");
        return false;
      }
    }
    
    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }
}
