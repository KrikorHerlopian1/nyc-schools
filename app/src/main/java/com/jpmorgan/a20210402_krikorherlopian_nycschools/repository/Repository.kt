package com.jpmorgan.a20210402_krikorherlopian_nycschools.repository

import androidx.lifecycle.LiveData
import com.jpmorgan.a20210402_krikorherlopian_nycschools.apiinterface.ApiInterfaceClient
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.SchoolRepoModel
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.Score
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.ScoreRepoModel


class Repository private constructor() {

    init {
        schoolsApiInterfaceClient = ApiInterfaceClient().instance
    }

    companion object {
        private var schoolsApiInterfaceClient: ApiInterfaceClient? = ApiInterfaceClient()

        fun getSchool(): LiveData<SchoolRepoModel> {
            return schoolsApiInterfaceClient!!.schools
        }
        fun getSchoolCall() {
            schoolsApiInterfaceClient!!.getSchoolsCall()
        }
        fun getScore(): LiveData<ScoreRepoModel> {
            return schoolsApiInterfaceClient!!.score
        }
        fun getScoreCall(dbn: String) {
            schoolsApiInterfaceClient!!.getScoreCall(dbn)
        }
    }
}