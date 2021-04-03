package com.jpmorgan.a20210402_krikorherlopian_nycschools.apiinterface;


import androidx.lifecycle.MutableLiveData;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.Score;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.service.ServiceGenerator;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;


public class ApiInterfaceClient {
    private MutableLiveData<List<School>> school = new MutableLiveData<List<School>>();
    private MutableLiveData<List<Score>> score = new MutableLiveData<List<Score>>();
    static ApiInterfaceClient instance = null;
    static String TAG = "ApiInterfaceClient";

    public ApiInterfaceClient getInstance(){
        if(instance == null){
            instance = new ApiInterfaceClient();
        }
        return instance;
    }
    public MutableLiveData<List<Score>> getScore(){
        return score;
    }
    public MutableLiveData<List<School>> getSchools(){
        return school;
    }
    public void getSchoolsCall(){
        Single<Response<List<School>>> call = ServiceGenerator.INSTANCE.getApiInterfaceApi().getSchools();
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<School>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onSuccess(Response<List<School>> value) {
                        List<School> result = value.body();
                        school.postValue(result);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }
    public void getScoreCall(String dbn){
        Single<Response<List<Score>>> call = ServiceGenerator.INSTANCE.getApiInterfaceApi().getScore(dbn);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<Score>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onSuccess(Response<List<Score>> value) {
                        List<Score> result = value.body();
                        score.postValue(result);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }
}

