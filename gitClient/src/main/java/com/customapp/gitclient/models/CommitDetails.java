package com.customapp.gitclient.models;


public class CommitDetails {


    private String version ;

    private String lastcommitsha;

    private String description;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastcommitsha() {
        return lastcommitsha;
    }

    public void setLastcommitsha(String lastcommitsha) {
        this.lastcommitsha = lastcommitsha;
    }



}
