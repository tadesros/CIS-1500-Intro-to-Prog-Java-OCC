package project3;
public class Geocache {
    //Class attributes
    private Double latitude;
    private Double longitude;
    private String hint;
    private String item;
    private int likeCount;

    //Constructor
    public Geocache(Double latitude, Double longitude,
                    String hint, String item)
    {
        //Initialize these values
        this.latitude = latitude;
        this.longitude = longitude;
        this.hint = hint;
        this.likeCount = likeCount;
        setItem(item);
    }

    //Setters
    public void setItem(String item) {
        this.item = item;
    }

    //Getters
    public Double getLatitude() {
        return latitude;
    }
    //Get longitude
    public Double getLongitude() {
        return longitude;
    }

    public String getHint() {
        return hint;
    }

    public String getItem() {
        return item;
    }

    public int getLikeCount() {
        return likeCount;
    }

    //Method for increasing like count
    public void like() {
        this.likeCount++;
    }
}
