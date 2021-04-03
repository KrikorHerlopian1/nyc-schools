package com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.ScoreRepoModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.repository.Repository;

public class ScoreViewModel extends ViewModel {
    public static LiveData<ScoreRepoModel> getScore(){
        return Repository.Companion.getScore();
    }
    public static void getScoreCall(String dbn){
        Repository.Companion.getScoreCall(dbn);
    }

}
