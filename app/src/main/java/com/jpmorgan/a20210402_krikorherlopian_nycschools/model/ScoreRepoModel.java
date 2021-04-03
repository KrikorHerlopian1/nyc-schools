package com.jpmorgan.a20210402_krikorherlopian_nycschools.model;

import java.util.List;

public class ScoreRepoModel {
    private List<Score> scoreList;
    private Throwable throwable;

    public ScoreRepoModel (List<Score>  scoreList) {
        this.scoreList= scoreList;
    }

    public ScoreRepoModel (Throwable throwable) {
        this.throwable = throwable;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
