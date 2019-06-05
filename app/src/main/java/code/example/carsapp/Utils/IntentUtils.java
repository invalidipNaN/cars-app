package code.example.carsapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentUtils {
    public static void startPhoneIntent(Context context, String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber ));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
