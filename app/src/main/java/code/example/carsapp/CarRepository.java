package code.example.carsapp;

import java.util.ArrayList;
import java.util.List;

import code.example.carsapp.DataSourceClasses.Listing;
import io.reactivex.Observable;

public class CarRepository {
    /**
     * getCarsData fetches the data either from the internet (when there is internet) or
     * from the database when offline
     * @return
     */
    public static Observable<List<CarDetails>> getCarsData(){
        return InternetDataSource.fetchCarsData().map(carSearchResult->{
            ArrayList<Listing> listings = carSearchResult.getListings();
            List<CarDetails> result = new ArrayList<>();

            if(listings != null){
                for(Listing l: listings){
                    String photo =
                            (l.getImages() != null )?l.getImages().getBaseUrl()+"1/640x480":"";
                    result.add(new CarDetails(l.getVin(),l.getYear(),l.getMake(),l.getModel(),
                            l.getTrim(),l.getSubTrim(),l.getDealer().getPhone(),l.getMileage(),
                            l.getCurrentPrice(),l.getExteriorColor(),l.getInteriorColor​(),
                            l.getEngine​(),l.getDisplacement(),l.getDrivetype(),l.getTransmission(),
                            l.getBodytype​(),l.getFuel(),photo,
                            l.getDealer().getCity(),l.getDealer().getState()));
                }
            }
            return result;
        });
    }
}
