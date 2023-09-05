package com.globant.data;

import org.testng.annotations.DataProvider;

public class DataTestProvider {
    @DataProvider(name = "invalid-login")
    public static Object[][] testDataInvalidLogIn() {
        return new Object[][] {
                {
                    "wrong",
                    "wrong"
                }
        };
    }
    @DataProvider(name = "valid-login")
    public static Object[][] testDataValidLogIn() {
        return new Object[][] {
                {
                    "standard_user",
                    "secret_sauce"
                }
        };
    }
}
