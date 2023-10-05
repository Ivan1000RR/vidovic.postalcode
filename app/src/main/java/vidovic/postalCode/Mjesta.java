package vidovic.postalCode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mjesta {

    @SerializedName("post code")
    private String postCode;
    private String country;
    @SerializedName("country abbreviation")
    private String countryAbbreviation;
    private List<Place> places;

    public Mjesta(String postCode,String country, String countryAbbreviation, List<Place> places) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.places = places;
    }

    public Mjesta(){

    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
