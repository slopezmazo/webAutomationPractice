package com.globant.tests;
import com.globant.data.DataTestProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
//    @Test(dataProvider = "invalid-login",dataProviderClass = DataTestProvider.class)
//    public void filloutLoginInvalid(String username,String password){
//        LoginPage.typeUsername(username);
//        LoginPage.typePassword(password);
//        LoginPage.clickLoginButton();
//    }

    @Test(dataProvider = "valid-login",dataProviderClass = DataTestProvider.class)
    public void filloutLoginValid(String username,String password){
        LoginPage.typeUsername(username);
        LoginPage.typePassword(password);
        LoginPage.clickLoginButton();
    }
}
