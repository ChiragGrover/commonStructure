package skycap.com.driver.go4er.views.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import skycap.com.driver.go4er.R;

public class CustomWindowInfoAdapter implements GoogleMap.InfoWindowAdapter {


    private Context context;

    public CustomWindowInfoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_custom_marker_info_window, null);

        TextView markerUserName = view.findViewById(R.id.markerUserName);
        TextView tvSubTitle = view.findViewById(R.id.markerPackageName);
        ImageView markeruserImage = view.findViewById(R.id.markerUserImage);

        //markerUserName.setText(marker.getTitle());
        tvSubTitle.setText(marker.getSnippet());
        String userNameWithImageUrl = marker.getTitle();

        String splitString[] = userNameWithImageUrl.split(" ");
        markerUserName.setText(splitString[0] + " " + splitString[1]);

        String imageUri = splitString[2];
        markeruserImage.setImageURI(Uri.parse(imageUri));


        return view;
    }
}