package com.jpmorgan.a20210402_krikorherlopian_nycschools.activity;

import android.os.Bundle;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = createFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
    protected abstract Fragment createFragment();
}
