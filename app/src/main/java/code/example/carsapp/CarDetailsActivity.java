package code.example.carsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import code.example.carsapp.Utils.IntentUtils;

public class CarDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extraPhoto";
    public static final String EXTRA_TITLE = "extraTitle";
    public static final String EXTRA_PRICE= "extraPrice";
    public static final String EXTRA_MILEAGE= "extraMileage";
    public static final String EXTRA_LOCATION= "extraLocation";
    public static final String EXTRA_EXTERIOR_COLOR= "extraExteriorColor";
    public static final String EXTRA_INTERIOR_COLOR= "extraInteriorColor";
    public static final String EXTRA_DRIVE_TYPE = "extraDriveType";
    public static final String EXTRA_TRANSMISSION = "extraTransmission";
    public static final String EXTRA_BODY_STYLE = "extraBodyStyle";
    public static final String EXTRA_ENGINE = "extraEngine";
    public static final String EXTRA_FUEL = "extraFuel";
    public static final String EXTRA_PHONE = "extraPhone";

    private ImageView mCarImageView;
    private TextView mTitleTextView;
    private TextView mPriceTextView;
    private TextView mMileageTextView;
    private TextView mLocationTextView;
    private TextView mExteriorColorTextView;
    private TextView mInteriorColorTextView;
    private TextView mDriveTypeTextView;
    private TextView mTransmissionTextView;
    private TextView mBodyStyleTextView;
    private TextView mEngineTextView;
    private TextView mFuelTextView;
    private Button   mCallDealerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        setUI();

        Intent intent = getIntent();
        String photo = intent.getStringExtra(EXTRA_PHOTO);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String price = intent.getStringExtra(EXTRA_PRICE);
        String mileage = intent.getStringExtra(EXTRA_MILEAGE);
        String location = intent.getStringExtra(EXTRA_LOCATION);
        String exteriorColor = intent.getStringExtra(EXTRA_EXTERIOR_COLOR);
        String interiorColor = intent.getStringExtra(EXTRA_INTERIOR_COLOR);
        String driveType = intent.getStringExtra(EXTRA_DRIVE_TYPE);
        String transmission = intent.getStringExtra(EXTRA_TRANSMISSION);
        String bodyStyle = intent.getStringExtra(EXTRA_BODY_STYLE);
        String engine = intent.getStringExtra(EXTRA_ENGINE);
        String fuel = intent.getStringExtra(EXTRA_FUEL);
        final String phone = intent.getStringExtra(EXTRA_PHONE);

        //FEED UI with data from Intent
        Glide.with(this)
                .load(photo)
                .into(mCarImageView);

        mTitleTextView.setText(title);

        String priceMileage = price + " | ";
        mPriceTextView .setText(priceMileage);

        mMileageTextView.setText(mileage);

        mLocationTextView.setText(location);

        mExteriorColorTextView.setText(exteriorColor);

        mInteriorColorTextView.setText(interiorColor);

        mDriveTypeTextView.setText(driveType);

        mTransmissionTextView.setText(transmission);

        mBodyStyleTextView.setText(bodyStyle);

        mEngineTextView.setText(engine);

        mFuelTextView.setText(fuel);

        mCallDealerButton.setOnClickListener(
                l->IntentUtils.startPhoneIntent(getApplicationContext(),phone));
    }

    public void setUI(){
        mCarImageView = findViewById(R.id.carImageView);
        mTitleTextView = findViewById(R.id.carTitleTextView);
        mPriceTextView = findViewById(R.id.carPriceTextView);
        mMileageTextView = findViewById(R.id.carMileageTextView);
        mLocationTextView = findViewById(R.id.carLocationTextView);
        mExteriorColorTextView = findViewById(R.id.carExteriorColorTextView);
        mInteriorColorTextView = findViewById(R.id.carInteriorColorTextView);
        mDriveTypeTextView = findViewById(R.id.carDriveTypeTextView);
        mTransmissionTextView = findViewById(R.id.carTransmissionTextView);
        mBodyStyleTextView = findViewById(R.id.carBodyStyleTextView);
        mEngineTextView = findViewById(R.id.carEngineTextView);
        mFuelTextView = findViewById(R.id.carFuelTextView);
        mCallDealerButton = findViewById(R.id.callDealerButton);
    }
}
