package code.example.carsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements CarsAdapter.ItemClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel mCarsViewModel;
    private RecyclerView mCarsRecyclerView;
    private ProgressBar mCarListProgressBar;
    private CarsAdapter mCarsAdapter;

    //Used for RxJava Cleanup
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the viewModel
        setupViewModel();

        //Set the RecyclerView
        setupRecyclerView();

        //Set the adapter
        mCarsAdapter = new CarsAdapter(this, this);
        populateAdapter();

        mCarsRecyclerView.setAdapter(mCarsAdapter);

        //Call the ViewModel to get the data
        fetchCarsData();

    }

    private void setupRecyclerView(){
        mCarsRecyclerView = findViewById(R.id.recyclerViewCars);
        mCarsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),
                VERTICAL);
        mCarsRecyclerView.addItemDecoration(decoration);
        mCarListProgressBar = findViewById(R.id.carListProgressBar);
    }

    private void setupViewModel() {
        mCarsViewModel = ViewModelProviders.of(this)
                .get(MainActivityViewModel.class);
    }

    private void fetchCarsData(){
        mCarsViewModel.fetchCarsData();
    }

    private void populateAdapter(){
        mCompositeDisposable.add(mCarsViewModel.getCarDetailsSubject().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        carDetails -> {
                            mCarListProgressBar.setVisibility(View.INVISIBLE);
                            mCarsAdapter.setmCarDetailsList(carDetails);
                            },
                        throwable -> Log.e(TAG, "Throwable " + throwable.getMessage())
                )
        );
    }

    @Override
    public void onItemClickListener(CarDetails car) {
        String photo = car.getPhoto();
        String title = CarDetails.title(car);

        String price = CarDetails.formattedPrice(car);
        String mileage = CarDetails.formattedMileage(car);
        String location = CarDetails.location(car);
        String exteriorColor = car.getExteriorColor();
        String interiorColor = car.getInteriorColor();
        String driveType = car.getDriveType();
        String transmission = car.getTransmission();
        String bodyStyle = car.getBodyType();
        String engine = CarDetails.formattedEngine(car);
        String fuel = car.getFuel();
        String phone = car.getPhone();


        Intent intent = new Intent(this, CarDetailsActivity.class);

        intent.putExtra(CarDetailsActivity.EXTRA_PHOTO, photo);
        intent.putExtra(CarDetailsActivity.EXTRA_TITLE, title);
        intent.putExtra(CarDetailsActivity.EXTRA_PRICE, price);
        intent.putExtra(CarDetailsActivity.EXTRA_MILEAGE, mileage);
        intent.putExtra(CarDetailsActivity.EXTRA_LOCATION, location);
        intent.putExtra(CarDetailsActivity.EXTRA_EXTERIOR_COLOR, exteriorColor);
        intent.putExtra(CarDetailsActivity.EXTRA_INTERIOR_COLOR, interiorColor);
        intent.putExtra(CarDetailsActivity.EXTRA_DRIVE_TYPE, driveType);
        intent.putExtra(CarDetailsActivity.EXTRA_TRANSMISSION, transmission);
        intent.putExtra(CarDetailsActivity.EXTRA_BODY_STYLE, bodyStyle);
        intent.putExtra(CarDetailsActivity.EXTRA_ENGINE, engine);
        intent.putExtra(CarDetailsActivity.EXTRA_FUEL, fuel);
        intent.putExtra(CarDetailsActivity.EXTRA_PHONE, phone);

        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCompositeDisposable.dispose();
        mCarsViewModel.stopModelViewSubject();
    }
}
