package code.example.carsapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import io.reactivex.Observable;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();

    private Observable<List<CarDetails>> mCarDetailsList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mCarDetailsList = CarRepository.getCarsData();
    }

    public Observable<List<CarDetails>> getmCarDetailsList() {
        return mCarDetailsList;
    }
}
