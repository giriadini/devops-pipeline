package com.customapp.gitclient.models;

import java.util.List;

/**
 *  value object class for CommitDetailsResponse
 */

public class CommitDetailsResponse {


    private List<CommitDetails> myapplication;

    public List<CommitDetails> getMyapplication() {
        return myapplication;
    }

    public void setMyapplication(List<CommitDetails> myapplication) {
        this.myapplication = myapplication;
    }

}
