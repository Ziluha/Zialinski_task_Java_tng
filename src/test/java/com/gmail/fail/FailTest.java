package com.gmail.fail;

import com.gmail.BaseTest;
import com.properties.PropertiesReading;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTest extends BaseTest{
    @Test(description = "Fail check")
    public void checkFail(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        pages.getLoginPage().submitLogin();
        Assert.assertTrue(pages.getPasswordPage().IsLoginApplied(),
                "Login was not applied");
    }
}
