package com.jpmorgan.a20210402_krikorherlopian_nycschools.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jpmorgan.a20210402_krikorherlopian_nycschools.activity.SchoolDetailActivity;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.adapter.SchoolListAdapter;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel.SchoolViewModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.databinding.FragmentSchoolListBinding;
import java.util.List;

//I used view binding  defined in gradle, to access the recyclerview instead of findviewbyid.
public class SchoolListFragment extends Fragment {
    private FragmentSchoolListBinding binding;
    SchoolListAdapter adapter;
    public static String SCHOOLOBJ = "com.jpmorgan.a20210402_krikorherlopian_nycschools.schoolobj";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSchoolListBinding.inflate(inflater, container, false);;
        View rootView = binding.getRoot();
        SchoolListAdapter.SchoolItemClickListener listener = new SchoolListAdapter.SchoolItemClickListener() {
            @Override
            public void onSchoolClicked(School school) {
                startSchoolDetailActivity(school);
            }
        };
        SchoolViewModel.getSchool().observe(this, new Observer<List<School>>() {
            @Override
            public void onChanged(List<School> school) {
                SchoolViewModel.sortBySchoolName(school);
                binding.progress.setVisibility(View.GONE);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adapter = new SchoolListAdapter(school, rootView.getContext(), listener);
                binding.recyclerView.setAdapter(adapter);
            }
        });


        if(savedInstanceState == null)
            SchoolViewModel.getSchoolCall();
        return rootView;
    }

    private void startSchoolDetailActivity(School school){
        Intent intent = new Intent(getActivity(), SchoolDetailActivity.class);
        intent.putExtra(SCHOOLOBJ, school);
        startActivity(intent);
    }
    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
