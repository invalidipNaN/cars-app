package code.example.carsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder> {

    private Context mContext;

    private List<CarDetails> mCarDetailsList;

    public CarsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.car_holder_layout, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CarViewHolder holder, int position) {
        CarDetails car = mCarDetailsList.get(position);
        String currentUrl = car.getPhoto();

        Glide.with(mContext)
                .load(currentUrl)
                .into(holder.carImage);

        String title = car.getYear() + " "+  car.getMake() + " " + car.getModel() +
                " "+ car.getTrim() +" "+ car.getSubTrim();
        final String phoneNumer = car.getPhone();

        holder.carTitle.setText(title);
        holder.carPrice.setText(""+car.getCurrentPrice());
        holder.carMileage.setText(""+car.getMileage());
        holder.callDealerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumer ));
                    if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                        mContext.startActivity(intent);
                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mCarDetailsList == null) {
            return 0;
        }
        return mCarDetailsList.size();
    }

    public List<CarDetails> getmCarDetailsList() {
        return mCarDetailsList;
    }

    public void setmCarDetailsList(List<CarDetails> mCarDetailsList) {
        this.mCarDetailsList = mCarDetailsList;
        notifyDataSetChanged();
    }

    /*
            Inner class that holds the item car details in the recycler view
         */
    public class CarViewHolder extends RecyclerView.ViewHolder{
        ImageView carImage;
        TextView carTitle;
        TextView carPrice;
        TextView carMileage;
        TextView carLocation;
        Button callDealerButton;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            carImage = itemView.findViewById(R.id.carImageView);
            carTitle = itemView.findViewById(R.id.carTitleTextView);
            carPrice = itemView.findViewById(R.id.carPriceTextView);
            carMileage = itemView.findViewById(R.id.carMileageTextView);
            carLocation = itemView.findViewById(R.id.carLocationTextView);
            callDealerButton = itemView.findViewById(R.id.callDealerButton);
        }
    }
}
