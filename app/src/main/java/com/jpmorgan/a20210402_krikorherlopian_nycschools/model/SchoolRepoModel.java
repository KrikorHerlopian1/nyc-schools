package com.jpmorgan.a20210402_krikorherlopian_nycschools.model;

import java.util.List;

public class SchoolRepoModel {
    private List<School> schoolList;
    private Throwable throwable;

    public SchoolRepoModel (List<School>  schoolList) {
        this.schoolList= schoolList;
    }

    public SchoolRepoModel (Throwable throwable) {
        this.throwable = throwable;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
