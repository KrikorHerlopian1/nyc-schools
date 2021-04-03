package com.jpmorgan.a20210402_krikorherlopian_nycschools.apiinterface;

import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.Score;
import java.util.List;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("s3k6-pzi2.json")
    public Single<Response<List<School>>> getSchools();

    @GET("f9bf-2cp4.json")
    public Single<Response<List<Score>>> getScore(@Query("dbn") String dbn);
}
