package com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.SchoolRepoModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.repository.Repository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SchoolViewModel extends ViewModel {
    public static LiveData<SchoolRepoModel> getSchool(){

        return Repository.Companion.getSchool();
    }
    public static void getSchoolCall(){
        Repository.Companion.getSchoolCall();
    }
    public static void sortBySchoolName(List<School> school){
        Collections.sort(school, new Comparator<School>() {
            public int compare(School s1, School s2) {
                return s1.getSchoolName().toString().compareToIgnoreCase(s2.getSchoolName().toString());
            }
        });
    }


}
