package code.example.carsapp;

import android.annotation.SuppressLint;

import code.example.carsapp.DataSourceClasses.CarSearchResult;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternetDataSource {

    private static final String sourceBaseUrl =
            "https://carfax-for-consumers.firebaseio.com/";

    @SuppressLint("CheckResult")
    public static Single<CarSearchResult> fetchCarsData(){
        Retrofit retrofitInstance = new Retrofit.Builder()
                .baseUrl(sourceBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        CarDetailsService service = retrofitInstance.create(CarDetailsService.class);

        return service.listCarSearchResults();
    }

}
