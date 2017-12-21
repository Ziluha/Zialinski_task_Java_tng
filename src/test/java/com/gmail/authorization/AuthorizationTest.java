package com.gmail.authorization;

import com.gmail.BaseTest;
import com.properties.PropertiesReading;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.extentReports.ExtentTestManager;

public class AuthorizationTest extends BaseTest{
    @Test(description = "Authorization with valid data")
    public void authWithValidData(){
        ExtentTestManager.getTest();
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue(pages.getInboxPage().isLoginSucceed(),
                "User was not logged in");
    }

    @Test(description = "Authorization with invalid login")
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        pages.getLoginPage().submitLogin();
        Assert.assertTrue(pages.getLoginPage().isLoginErrorLabelPresented(),
                "Login Error Label is not presented");
    }

    @Test(description = "Authorization with invalid password")
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("invalidPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue(pages.getPasswordPage().isPasswordErrorLabelPresented(),
                "Password Error Label is not presented");
    }
}
