package code.example.carsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements CarsAdapter.ItemClickListener{

    private RecyclerView mCarsRecyclerView;
    private CarsAdapter mCarsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCarsRecyclerView = findViewById(R.id.recyclerViewCars);
        mCarsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCarsAdapter = new CarsAdapter(this, this);

        mCarsRecyclerView.setAdapter(mCarsAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),
                VERTICAL);
        mCarsRecyclerView.addItemDecoration(decoration);

        List<CarDetails> mList = new ArrayList<>();
        String photoUrl  = "https://carfax-img.vast.com/carfax/-6601530003191280406/1/640x480";
        String photo2Url = "https://carfax-img.vast.com/carfax/-9050308143659109979/1/640x480";
        CarDetails bmw = new CarDetails("hjhdsjqhjds",2014,"BMW","Seri",
                "ds","i25","56515545",526,2356.0f,
                "Black","Red","V2","SSS",
                "manual","DS","Electric",photoUrl,"Nevada",
                "Nevada");
        CarDetails bk = new CarDetails("tyuaeizae",2016,"Audi","dsq",
                "ds","i25","56515545",526,2356.0f,
                "Blue","Red","V2","SSS",
                "manual","DS","Gazoline",photo2Url,"Los angeles",
                "CA");
        mList.add(bmw);
        mList.add(bk);
        mList.add(bmw);
        mList.add(bk);
        mList.add(bmw);
        mList.add(bk);
        mCarsAdapter.setmCarDetailsList(mList);
    }

    @Override
    public void onItemClickListener(CarDetails car) {
        String photo = car.getPhoto();
        String title = car.getYear() + " "+  car.getMake() + " " + car.getModel() +
                " "+ car.getTrim() +" "+ car.getSubTrim();

        String price = "$ "+ car.getCurrentPrice();
        String mileage = car.getMileage() + "k mi";
        String location = car.getCity() + ", " + car.getState();
        String exteriorColor = car.getExteriorColor();
        String interiorColor = car.getInteriorColor();
        String driveType = car.getDriveType();
        String transmission = car.getTransmission();
        String bodyStyle = car.getBodyType();
        String engine = car.getEngine();
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
}
