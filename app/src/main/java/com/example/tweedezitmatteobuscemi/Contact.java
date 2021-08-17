package com.example.tweedezitmatteobuscemi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Contact extends FragmentActivity implements OnMapReadyCallback {
    EditText etTo,etSubject,etMessage;
    Button btSend;
    GoogleMap map;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        /*etTo = findViewById(R.id.et_to);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        btSend = findViewById(R.id.bt_send);

        btSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w) {
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + etTo.getText().toString()));
               intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
               intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
               startActivity(intent);
            }
        });*/

        myDialog = new Dialog(this);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //Initialize And Assing Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.contact);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                ,Info.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.contact:
                        return true;
                }
                return false;
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void ShowPopup (View v) {
        myDialog.setContentView(R.layout.custompopupcontact);
        myDialog.show();

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Meise = new LatLng(50.92321849299421, 4.3417860449400045);
        map.addMarker(new MarkerOptions().position(Meise).title("Cyberbully App HQ"));
        //map.moveCamera(CameraUpdateFactory.newLatLng(Meise));
        float zoomLevel = 16.0f; //This goes up to 21
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Meise, zoomLevel));
    }
}