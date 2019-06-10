package code.example.carsapp;

import code.example.carsapp.DataSourceClasses.CarSearchResult;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CarDetailsService {
    @GET("/assignment.json")
    Observable<CarSearchResult> listCarSearchResults();
}
