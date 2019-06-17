package code.example.carsapp;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();

    private PublishSubject<List<CarDetails>> mCarDetailsSubject = PublishSubject.create();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public Observable<List<CarDetails>> getCarDetailsSubject() {
        return mCarDetailsSubject;
    }

    public void fetchCarsData() {
        mCompositeDisposable.add(CarRepository.getCarsData().subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation()).subscribe(list->
                        mCarDetailsSubject.onNext(list),
                        throwable -> Log.e(TAG, "Throwable " + throwable.getMessage()
                        )));
    }

    public void stopModelViewSubject(){
        mCompositeDisposable.dispose();
    }

}
