package com.jpmorgan.a20210402_krikorherlopian_nycschools.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.jpmorgan.a20210402_krikorherlopian_nycschools.R;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.fragment.SchoolDetailFragment;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.fragment.SchoolListFragment;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;

public class SchoolDetailActivity extends SingleFragmentActivity {
    public static String SCHOOLOBJ = "com.jpmorgan.a20210402_krikorherlopian_nycschools.schoolobj";
    @Override
    protected Fragment createFragment() {
        Fragment frag = new SchoolDetailFragment();
        School school = (School)getIntent().getExtras().getSerializable(SchoolListFragment.SCHOOLOBJ);
        Toolbar actionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");
        actionBar.setTitle(school.getDbn());
        actionBar.setElevation(4.0F);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putSerializable(SCHOOLOBJ, school);
        frag.setArguments(bundle);
        return frag;
    }
}
