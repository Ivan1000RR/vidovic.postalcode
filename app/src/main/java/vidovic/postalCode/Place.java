package vidovic.postalCode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Place implements Serializable {
    @SerializedName("place name")
    private String place_name;
    private String longitude;
    private String state;
    @SerializedName("state abbreviation")
    private String state_abbreviation;
    private String latitude;

    public Place(String place_name, String longitude, String state, String state_abbreviation, String latitude) {
        this.place_name = place_name;
        this.longitude = longitude;
        this.state = state;
        this.state_abbreviation = state_abbreviation;
        this.latitude = latitude;
    }

    public Place(){

    }

    @Override
    public String toString() {
        return "Mjesto: " + place_name + "\n" +
                "Županija: " + state;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_abbreviation() {
        return state_abbreviation;
    }

    public void setState_abbreviation(String state_abbreviation) {
        this.state_abbreviation = state_abbreviation;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}