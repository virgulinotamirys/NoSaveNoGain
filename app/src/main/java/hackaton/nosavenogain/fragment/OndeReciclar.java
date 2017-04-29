package hackaton.nosavenogain.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import hackaton.nosavenogain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OndeReciclar extends Fragment {
    private SupportMapFragment mSupportMapFragment;

    public OndeReciclar() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_onde_reciclar, container, false);

        mSupportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mSupportMapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mSupportMapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mSupportMapFragment).commit();
        }

        if (mSupportMapFragment != null) {
            mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (googleMap != null) {

                        googleMap.getUiSettings().setAllGesturesEnabled(true);

                        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(-10.2489654, -48.3250894)).zoom(12.5f).build();
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                        googleMap.moveCamera(cameraUpdate);

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.2463575, -48.3233088)));

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.2296058, -48.3347592)));

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.2226333, -48.3165255)));

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.1835584, -48.3401148)));

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.179543, -48.3266089)));

                        googleMap.addMarker(new MarkerOptions().position(new LatLng(-10.2650295, -48.3279072)));

                    }

                }
            });
        }
        return view;
    }

}
