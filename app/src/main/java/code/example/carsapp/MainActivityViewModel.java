package code.example.carsapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import code.example.carsapp.DataSourceClasses.Listing;
import io.reactivex.Single;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();

    private Single<List<CarDetails>> mCarDetailsList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mCarDetailsList = InternetDataSource.fetchCarsData().map(carSearchResult->{
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

    public Single<List<CarDetails>> getmCarDetailsList() {
        return mCarDetailsList;
    }
}
