package com.gmail.drafts;

import com.gmail.BaseTest;
import com.properties.PropertiesReading;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DraftsTest extends BaseTest{
    @BeforeMethod
    public void setUpAuth(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        pages.getPasswordPage().submitPassword();
    }

    @Test(description = "Adding massage to drafts")
    public void addMessageToDrafts(){
        pages.getInboxPage().clickComposeButton();
        pages.getInboxPage().inputMessageSubject("example");
        Assert.assertTrue(pages.getInboxPage().isSavedLabelPresented(),
                "Saved Label is not presented");
        pages.getInboxPage().clickDraftsLink();
        Assert.assertTrue(pages.getDraftsPage().isDraftPageOpened(),
                "Draft Page is not opened");
        Assert.assertTrue(pages.getDraftsPage().isDraftAdded("example"),
                "No message with this subject in drafts");
    }

    @Test(description = "deleting message from drafts")
    public void deleteMessageFromDrafts(){
        pages.getInboxPage().clickDraftsLink();
        Assert.assertTrue(pages.getDraftsPage().isDraftPageOpened(), "Draft Page is not opened");
        pages.getDraftsPage().chooseFirstDraft();
        int countOfDraftsAtStart = pages.getDraftsPage().getCountOfDrafts();
        pages.getDraftsPage().clickDiscardDraftButton();
        Assert.assertEquals(countOfDraftsAtStart-1, pages.getDraftsPage().getCountOfDrafts(),
                "Count of drafts at start and after discarding doesn't match");
    }
}
