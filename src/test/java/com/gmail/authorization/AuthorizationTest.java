package com.gmail.authorization;

import com.gmail.BaseTest;
import com.properties.PropertiesReading;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest{
    @Test
    public void authWithValidData(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue(pages.getInboxPage().isLoginSucceed(),
                "User was not logged in");
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        pages.getLoginPage().submitLogin();
        Assert.assertTrue(pages.getLoginPage().isLoginErrorLabelPresented(),
                "Login Error Label is not presented");
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("invalidPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue(pages.getPasswordPage().isPasswordErrorLabelPresented(),
                "Password Error Label is not presented");
    }
}
