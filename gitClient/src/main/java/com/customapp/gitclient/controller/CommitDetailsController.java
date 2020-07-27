package com.customapp.gitclient.controller;

import com.customapp.gitclient.models.CommitDetails;
import com.customapp.gitclient.models.CommitDetailsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommitDetailsController {


    @Value("${git.commit.message.full}")
    private String description;

    @Value("${git.build.version}")
    private String buildVersion;

    @Value("${git.commit.id.abbrev}")
    private String commitId;

    @RequestMapping("/version")
    public CommitDetailsResponse getCommitDetails() {

        CommitDetails commitDetails = new CommitDetails();
        commitDetails.setVersion(buildVersion);
        commitDetails.setLastcommitsha(commitId);
        commitDetails.setDescription(description);

        List<CommitDetails> commitList = new ArrayList<>();
        commitList.add(commitDetails);
        CommitDetailsResponse myApplication = new CommitDetailsResponse();
        myApplication.setMyapplication(commitList);

        return myApplication;
    }

}