package com.jpmorgan.a20210402_krikorherlopian_nycschools.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.activity.SchoolDetailActivity;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.databinding.SchoolDetailBinding;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.Score;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel.ScoreViewModel;

import java.util.List;

public class SchoolDetailFragment extends Fragment implements OnMapReadyCallback {
    private School school;
    private GoogleMap mMap;
    private SchoolDetailBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SchoolDetailBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            school = (School)bundle.getSerializable(SchoolDetailActivity.SCHOOLOBJ);
            binding.setSchool(school);
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentByTag("google-map");
        mapFragment.getMapAsync(this);

        ScoreViewModel.getScore().observe(this, new Observer<List<Score>>() {
            @Override
            public void onChanged(List<Score> score) {
                if(score.size() > 0){
                    binding.setScore(score.get(0));
                }
            }
        });

        if(savedInstanceState == null)
            ScoreViewModel.getScoreCall(school.getDbn());
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker and move the camera
        if(school.getLat() != null && !school.getLat().equals("") && school.getLng() != null && !school.getLng().equals("")){
            LatLng location = new LatLng(Double.parseDouble(school.getLat()), Double.parseDouble(school.getLng()));
            mMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title(school.getSchoolName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        }
    }
}
