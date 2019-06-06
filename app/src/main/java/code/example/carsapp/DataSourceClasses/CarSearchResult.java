package code.example.carsapp.DataSourceClasses;

import java.util.ArrayList;

public class CarSearchResult {
    private ArrayList<Listing> listings;

    public ArrayList<Listing> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
    }
}
