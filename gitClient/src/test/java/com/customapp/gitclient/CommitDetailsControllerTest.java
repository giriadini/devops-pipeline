package com.customapp.gitclient;

import com.customapp.gitclient.controller.CommitDetailsController;
import com.customapp.gitclient.models.CommitDetailsResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;


@RunWith(SpringRunner.class)
public class CommitDetailsControllerTest {


    @InjectMocks
    public CommitDetailsController commitDetailsController;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(commitDetailsController, "commitId", "19b322b");
        ReflectionTestUtils.setField(commitDetailsController, "description", "First Commit");
        ReflectionTestUtils.setField(commitDetailsController, "buildVersion", "0.1-SNAPSHOT");
    }

   @Test
    public void getCommitDetailsTest() {

        CommitDetailsResponse result = commitDetailsController.getCommitDetails();
        Assert.assertEquals(result.getMyapplication().get(0).getLastcommitsha(),"19b322b");
        Assert.assertEquals(result.getMyapplication().get(0).getDescription(),"First Commit");
        Assert.assertEquals(result.getMyapplication().get(0).getVersion(),"0.1-SNAPSHOT");

    }


}
