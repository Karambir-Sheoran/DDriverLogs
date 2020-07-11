package com.example.ddriverlogs;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;


/**
 * A simple k007 @link  Activity subclass.
 */

public class MainActivity extends AppCompatActivity implements ListFragment.OnHeadlineSelectedListener {

    private String loc = "karambir";
    private String message = "Null";
    private  String row = "Null";
    int PERMISSION_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.app_bar);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        getLastLocation();
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.mainUp, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.mainUp));
        }

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof ListFragment) {
            ListFragment headlinesFragment = (ListFragment) fragment;
            headlinesFragment.setOnHeadlineSelectedListener(this);
        }
    }

    public void onArticleSelected(ArrayList<String> position, String name) {

        row = name;
        StringBuilder s = new StringBuilder(row+" Log Entries: ");
        if(position.size() > 0) {

            for (int i = 0; i < position.size(); i++) {
                s.append("\n").append(position.get(i));

            }
        }
        message = s.toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.send:

                ListFragment ft = (ListFragment) getSupportFragmentManager().findFragmentByTag("list_frag");
                if (ft != null && ft.isVisible()) {
                    String[] To = {"karambir@frisklancer.com"};
                    composeEmail(To,"testing purpose",row);

                }
                else{
                    Toast.makeText(getApplication(),"First go to Show Log entries!!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.save:
                Toast.makeText(getApplicationContext(),"Data Saved!", Toast.LENGTH_SHORT).show();

                break;
            case R.id.profile:
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main_frag, new ProfileFragment());
                fm.commit();
                break;
            default:
                Toast.makeText(getApplicationContext(), "default error please check", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("IntentReset")
    public void composeEmail(String[] addresses, String subject,String name) {


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        MyHelper db = new MyHelper(this);
        db.cleanDb(name);
        Toast.makeText(getApplicationContext(),"Sent Records Deleted!!",Toast.LENGTH_SHORT).show();
    }

    private void setLoc(String val) {
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        RootFragment obj2 = new RootFragment();
        Bundle args = new Bundle();
        args.putString("karam", val);
        obj2.setArguments(args);
        fm.add(R.id.main_frag, obj2,"root_f");
        fm.commit();
    }
    @SuppressLint("MissingPermission")

    private void getLastLocation(){
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {

                                    loc = " Longitude: "+location.getLatitude()+" Latitude: "+location.getLongitude();
                                    Log.d("room2", loc);
                                    setLoc(loc);
                                    requestNewLocationData();
                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
               startActivity(intent);

            }
        } else {
            requestPermissions();
        }

    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData(){

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {

            Location mLastLocation = locationResult.getLastLocation();
            loc = "Last Longitude:-"+mLastLocation.getLatitude()+"Last Latitude:-"+mLastLocation.getLongitude();
            Log.d("room1",loc);
            setLoc(loc);
        }
    };

    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                MainActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
        setLoc("null");
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(locationManager != null) {
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                    LocationManager.NETWORK_PROVIDER
            );
        }
        else return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }

    }

}
