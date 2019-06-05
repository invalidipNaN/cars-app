package code.example.carsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCarsRecyclerView;
    private CarsAdapter mCarsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCarsRecyclerView = findViewById(R.id.recyclerViewCars);
        mCarsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCarsAdapter = new CarsAdapter(this);

        mCarsRecyclerView.setAdapter(mCarsAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),
                VERTICAL);
        mCarsRecyclerView.addItemDecoration(decoration);

        List<CarDetails> mList = new ArrayList<>();
        String photoUrl  = "https://carfax-img.vast.com/carfax/-6601530003191280406/1/640x480";
        CarDetails bmw = new CarDetails("hjhdsjqhjds",2014,"BMW","Seri",
                "ds","i25","56515545",526,2356.0f,
                "Black","Red","V2","SSS",
                "manual","DS",photoUrl);
        CarDetails bk = new CarDetails("tyuaeizae",2016,"Audi","dsq",
                "ds","i25","56515545",526,2356.0f,
                "Blue","Red","V2","SSS",
                "manual","DS",photoUrl);
        mList.add(bmw);
        mList.add(bk);
        mList.add(bmw);
        mList.add(bk);
        mList.add(bmw);
        mList.add(bk);
        mCarsAdapter.setmCarDetailsList(mList);
    }
}
