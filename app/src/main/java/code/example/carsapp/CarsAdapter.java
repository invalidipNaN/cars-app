package code.example.carsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import code.example.carsapp.Utils.IntentUtils;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder> {

    private Context mContext;
    private ItemClickListener mItemClickListener;

    private List<CarDetails> mCarDetailsList = new ArrayList<>();

    public CarsAdapter(Context mContext, ItemClickListener itemClickListener) {

        this.mContext = mContext;
        this.mItemClickListener = itemClickListener;
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
                //.placeholder(new ColorDrawable(Color.RED))
                .into(holder.carImage);

        String title = CarDetails.title(car);
        String price = CarDetails.formattedPrice(car);
        String mileage = CarDetails.formattedMileage(car);
        String location = CarDetails.location(car);


        final String phoneNumber = car.getPhone();

        holder.carTitle.setText(title);
        holder.carPrice.setText(price);
        holder.carMileage.setText(mileage);
        holder.carLocation.setText(location);

        /*
            Create an intent to call the car dealer
         */
        holder.callDealerButton.setOnClickListener(
                e->IntentUtils.startPhoneIntent(mContext,phoneNumber));
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
    public class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView carImage;
        TextView carTitle;
        TextView carPrice;
        TextView carMileage;
        TextView carLocation;
        Button callDealerButton;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            //Listener on the itemVie
            itemView.setOnClickListener(this);
            carImage = itemView.findViewById(R.id.carImageView);
            carTitle = itemView.findViewById(R.id.carTitleTextView);
            carPrice = itemView.findViewById(R.id.carPriceTextView);
            carMileage = itemView.findViewById(R.id.carMileageTextView);
            carLocation = itemView.findViewById(R.id.carLocationTextView);
            callDealerButton = itemView.findViewById(R.id.callDealerButton);

        }

        @Override
        public void onClick(View v) {
            CarDetails car = mCarDetailsList.get(getAdapterPosition());
            mItemClickListener.onItemClickListener(car);
        }
    }

    public interface ItemClickListener {
        void onItemClickListener(CarDetails item);
    }
}
