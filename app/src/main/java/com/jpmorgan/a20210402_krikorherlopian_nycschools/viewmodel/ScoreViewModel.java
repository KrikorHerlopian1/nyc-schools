package com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.Score;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.repository.Repository;
import java.util.List;

public class ScoreViewModel extends ViewModel {
    public static LiveData<List<Score>> getScore(){
        return Repository.Companion.getScore();
    }
    public static void getScoreCall(String dbn){
        Repository.Companion.getScoreCall(dbn);
    }

}
